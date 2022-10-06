package cn.nukkit.level.format.leveldb;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.level.GameRules;
import cn.nukkit.level.Level;
import cn.nukkit.level.format.ChunkSection;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.level.format.LevelProvider;
import cn.nukkit.level.format.anvil.Chunk;
import cn.nukkit.level.format.generic.BaseFullChunk;
import cn.nukkit.level.format.generic.serializer.NetworkChunkSerializer;
import cn.nukkit.level.format.leveldb.data.*;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.scheduler.AsyncTask;
import cn.nukkit.utils.ChunkException;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import lombok.extern.log4j.Log4j2;
import net.daporkchop.ldbjni.LevelDB;
import net.daporkchop.ldbjni.direct.DirectDB;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Log4j2
public class LevelDBFormat implements LevelProvider {
    public static final int VERSION = 19133;
    public static final byte CHUNK_VERSION = 27;

    private final Level level;
    private final String path;
    private final File dir, levelFile, dbDir;
    private final DB db;
    private final LevelDBData levelDBData;


    private boolean closed = false;

    private GameRules gameRules;
    private Vector3 spawn;

    private final Long2ObjectMap<LevelDBChunk> chunks = new Long2ObjectOpenHashMap<>();

    public LevelDBFormat(Level level, String path) throws IOException {
        this.level = level;
        this.path = path;

        this.dir = new File(path);
        this.levelFile = new File(this.dir, "level.dat");
        this.dbDir = new File(this.dir, "db");

        this.levelDBData = new LevelDBData(this.levelFile);
        this.db = LevelDB.PROVIDER.open(this.dbDir, new Options().createIfMissing(true));
        init();
    }

    private void init() throws IOException {
        this.levelDBData.load();
        this.gameRules = this.levelDBData.getGameRules();
        this.spawn = new Vector3(this.levelDBData.getSpawnX(), this.levelDBData.getSpawnY(), this.levelDBData.getSpawnZ());
    }


    @Override
    public Chunk getEmptyChunk(int chunkX, int chunkZ) {
        return Chunk.getEmptyChunk(chunkX, chunkZ, this);
    }

    @Override
    public void saveChunks() {
        synchronized (chunks) {
            for (LevelDBChunk chunk : this.chunks.values()) {
                if (chunk.getChanges() != 0) {
                    chunk.setChanged(false);
                    try {
                        this.saveChunkI(chunk);
                    } catch (IOException e) {
                        throw new ChunkException("Error saving chunk (" + getName() + ", " + chunk.getX() + ", " + chunk.getZ() + ")", e);
                    }
                }
            }
        }
    }

    @Override
    public AsyncTask requestChunkTask(int x, int z) throws ChunkException {
        Chunk chunk = (Chunk) this.getChunk(x, z, false);
        if (chunk == null) {
            throw new ChunkException("Invalid Chunk Set");
        }

        long timestamp = chunk.getChanges();
        BiConsumer<Int2ObjectMap<byte[]>, Integer> callback = (payload, subchunks) ->
                this.getLevel().chunkRequestCallback(timestamp, x, z, subchunks, payload);
        NetworkChunkSerializer.serialize(chunk, callback, this.level.getDimensionData());
        return null;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getGenerator() {
        return Generator.getGenerator(this.levelDBData.getGenerator()).getSimpleName().toLowerCase();
    }

    @Override
    public Map<String, Object> getGeneratorOptions() {
        return new HashMap<String, Object>() {{
            put("preset", "");
        }};
    }

    @Override
    public BaseFullChunk getLoadedChunk(int X, int Z) {
        return getLoadedChunk(Level.chunkHash(X, Z));
    }

    @Override
    public BaseFullChunk getLoadedChunk(long hash) {
        return this.chunks.get(hash);
    }

    @Override
    public BaseFullChunk getChunk(int X, int Z) {
        return getChunk(X, Z, false);
    }

    @Override
    public BaseFullChunk getChunk(int X, int Z, boolean create) {
        long index = Level.chunkHash(X, Z);

        LevelDBChunk chunk = this.chunks.get(index);
        if (chunk == null) {
            chunk = this.loadChunkI(index, X, Z, create);
        }
        return chunk;
    }


    @Override
    public void doGarbageCollection(long time) {

    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public void close() {
        if (this.closed) {
            throw new IllegalStateException("This provider is already closed.");
        }
        this.closed = true;
        this.unloadChunks();
        this.saveLevelData();
        try {
            this.db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveLevelData() {
        try {
            this.levelDBData.save();
        } catch (IOException e) {
            log.error("Failed to save level data", e);
        }
    }

    @Override
    public void updateLevelName(String name) {
        this.levelDBData.setLevelName(name);
    }

    @Override
    public GameRules getGamerules() {
        return gameRules;
    }

    @Override
    public void setGameRules(GameRules rules) {
        this.gameRules = rules;
        try {
            this.levelDBData.setGameRuleFields(rules);
        } catch (IllegalAccessException e) {
            log.error("Failed to save GameRules", e);
        }
    }


    private boolean chunkExists( int x, int z, int dimension) {
        if (dimension == Level.DIMENSION_OVERWORLD) {
            return this.db.get(LevelDBKeys.CHUNK_VERSION.getKey(x, z)) != null;
        } else {
            return this.db.get(LevelDBKeys.CHUNK_VERSION.getKeyForDimension(x, z, dimension)) != null;

        }
    }


    @Override
    public synchronized void saveChunk(int X, int Z) {
        BaseFullChunk chunk = this.getChunk(X, Z);
        if (chunk != null) {
            try {
                this.saveChunkI((LevelDBChunk) chunk);
            } catch (IOException e) {
                throw new ChunkException("Error saving chunk (" + X + ", " + Z + ") of World " + getName(), e);
            }
        }
    }


    @Override
    public synchronized void saveChunk(int x, int z, FullChunk chunk) {
        if (chunk instanceof LevelDBChunk) {
            LevelDBChunk levelDBChunk = (LevelDBChunk) chunk;
            levelDBChunk.setX(x);
            levelDBChunk.setZ(z);
            try {
                this.saveChunkI(levelDBChunk);
            } catch (IOException e) {
                throw new ChunkException("Error saving chunk (" + x + ", " + z + ") of World " + getName(), e);
            }
        } else {
            throw new ChunkException("Invalid Chunk class " + chunk.getClass().getName());
        }
    }

    @Override
    public void unloadChunks() {
        synchronized (chunks) {
            Iterator<LevelDBChunk> iter = chunks.values().iterator();
            while (iter.hasNext()) {
                iter.next().unload(true, false);
                iter.remove();
            }
        }
    }

    @Override
    public boolean loadChunk(int X, int Z) {
        return false;
    }

    @Override
    public boolean loadChunk(int X, int Z, boolean create) {
        return false;
    }

    public synchronized LevelDBChunk loadChunkI(long index, int x, int z, boolean create) {

        this.level.timings.syncChunkLoadTimer.startTiming();

        int dimension = level.getDimension();

        if (!this.chunkExists(x, z, dimension) && !create) {
            return null;
        }

        try {
            byte chunkVersion = this.getChunkVersion(x, z, dimension);
            LevelDBChunkData chunkData = this.getChunkData(x, z, dimension);
            Set<CompoundTag> blockEntities = this.getBlockEntitiesNBT(x, z, dimension);
            Set<CompoundTag> entities = this.getEntitiesNBT(x, z, dimension);

            LevelDBChunk levelDBChunk = new LevelDBChunk(this, x, z, dimension );

            levelDBChunk.setVersion(chunkVersion);
            levelDBChunk.setBiomeMap(chunkData.getBiomeMap());
            levelDBChunk.setHeightMap(chunkData.getHeightMap());

            if (dimension == 0) {
                for (int subChunkIndex = -4; subChunkIndex < 20; subChunkIndex++) {
                    levelDBChunk.setSection(subChunkIndex + 4, loadSubChunk(x, z, dimension, subChunkIndex + 4));
                }
            } else {
                for (int subChunkIndex = 0; subChunkIndex < 16; subChunkIndex++) {
                    levelDBChunk.setSection(subChunkIndex, loadSubChunk(x, z, dimension, subChunkIndex));
                }
            }

            return levelDBChunk;

        } catch (Exception e) {
            log.error("Failed to load Chunk at " + getName() + "(" + dimension + "), " + x + ", " + z, e);
        }
        return null;
    }

    private LevelDBChunkSection loadSubChunk(int x, int z, int dimension, int subChunkIndex) throws IOException {
        byte[] subChunkData = this.getDbValue(LevelDBKeys.SUB_CHUNK_PREFIX, (byte) subChunkIndex, x, z, dimension);
        if (subChunkData == null) {
            subChunkData = new byte[]{8, 0};
        }
        return LevelDBChunkSection.read(subChunkData, subChunkIndex);
    }

    private void saveChunkI(LevelDBChunk chunk) throws IOException {

        // Chunk Version
        this.putDbValue(LevelDBKeys.CHUNK_VERSION, chunk.getX(), chunk.getZ(), level.getDimension(), new byte[]{chunk.getVersion()});
        // Data3D
        this.putDbValue(LevelDBKeys.DATA_3D, chunk.getX(), chunk.getZ(), level.getDimension(), new LevelDBChunkData(chunk.getHeightMap(), chunk.getBiomeMap()).write());
        // Block Entities
        this.putDbValue(LevelDBKeys.BLOCK_ENTITY, chunk.getX(), chunk.getZ(), level.getDimension(), LevelDBCompoundSet.write(chunk.getBlockEntities().values().stream().map(blockEntity -> blockEntity.namedTag).collect(Collectors.toSet())));
        // Entities
        this.putDbValue(LevelDBKeys.BLOCK_ENTITY, chunk.getX(), chunk.getZ(), level.getDimension(), LevelDBCompoundSet.write(chunk.getEntities().values().stream().map(entity -> entity.namedTag).collect(Collectors.toSet())));

        int subChunkStartIndex = level.getDimension() == 0 ? -4 : 0;
        int subChunkCount = level.getDimension() == 0 ? 24 : 16;
        for (int subChunkIndex = 0; subChunkIndex < subChunkCount; subChunkIndex++) {
            byte dbIndex = (byte) (subChunkIndex + subChunkStartIndex);
            ChunkSection chunkSection = chunk.getSection(subChunkIndex);
            byte[] data = null;
            if (chunkSection instanceof LevelDBChunkSection) {
                data = ((LevelDBChunkSection) chunkSection).write();
            }
            this.putDbValue(LevelDBKeys.SUB_CHUNK_PREFIX, dbIndex, chunk.getX(), chunk.getZ(), level.getDimension(), data);
        }
    }


    @Override
    public boolean unloadChunk(int X, int Z) {
        return unloadChunk(X, Z, true);
    }

    @Override
    public boolean unloadChunk(int X, int Z, boolean safe) {
        long index = Level.chunkHash(X, Z);
        synchronized (chunks) {
            LevelDBChunk chunk = this.chunks.get(index);
            if (chunk != null && chunk.unload(false, safe)) {
                this.chunks.remove(index, chunk);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isChunkGenerated(int X, int Z) {
        return false;
    }

    public void setChunkGenerated(int x, int z, boolean val) {

    }

    @Override
    public boolean isChunkPopulated(int X, int Z) {
        return false;
    }

    public void setChunkPopulated(int x, int z, boolean val) {

    }

    @Override
    public boolean isChunkLoaded(int X, int Z) {
        return isChunkLoaded(Level.chunkHash(X, Z));
    }

    @Override
    public boolean isChunkLoaded(long hash) {
        synchronized (chunks) {
            return this.chunks.containsKey(hash);
        }
    }

    @Override
    public void setChunk(int chunkX, int chunkZ, FullChunk chunk) {
        if (chunk instanceof LevelDBChunk) {
            LevelDBChunk levelDBChunk = (LevelDBChunk) chunk;
            levelDBChunk.setProvider(this);
            levelDBChunk.setPosition(chunkX, chunkZ);
            long index = Level.chunkHash(chunkX, chunkZ);
            synchronized (chunks) {
                if (this.chunks.containsKey(index) && !this.chunks.get(index).equals(levelDBChunk)) {
                    this.unloadChunk(chunkX, chunkZ, false);
                }
                this.chunks.put(index, levelDBChunk);
            }
        } else {
            throw new ChunkException("Invalid Chunk class " + chunk.getClass().getName());
        }
    }

    public static ChunkSection createChunkSection(int y) {
        return new LevelDBChunkSection(y);
    }

    @Override
    public String getName() {
        return this.levelDBData.getLevelName();
    }

    @Override
    public boolean isRaining() {
        return this.levelDBData.getRainLevel() > 0;
    }

    @Override
    public void setRaining(boolean raining) {
        this.levelDBData.setRainLevel(raining ? 1 : 0);
    }

    @Override
    public int getRainTime() {
        return this.levelDBData.getRainTime();
    }

    @Override
    public void setRainTime(int rainTime) {
        this.levelDBData.setRainTime(rainTime);
    }

    @Override
    public boolean isThundering() {
        return this.levelDBData.getLightningLevel() > 1;
    }

    @Override
    public void setThundering(boolean thundering) {
        this.levelDBData.setLightningLevel(thundering ? 1 : 0);
    }

    @Override
    public int getThunderTime() {
        return this.levelDBData.getLightningTime();
    }

    @Override
    public void setThunderTime(int thunderTime) {
        this.levelDBData.setLightningTime(thunderTime);
    }

    @Override
    public long getCurrentTick() {
        return this.levelDBData.getCurrentTick();
    }

    @Override
    public void setCurrentTick(long currentTick) {
        this.levelDBData.setCurrentTick(currentTick);
    }

    @Override
    public long getTime() {
        return this.levelDBData.getTime();
    }

    @Override
    public void setTime(long value) {
        this.levelDBData.setTime(value);
    }

    @Override
    public long getSeed() {
        return levelDBData.getRandomSeed();
    }

    @Override
    public void setSeed(long value) {
        this.levelDBData.setRandomSeed(value);
    }

    @Override
    public Vector3 getSpawn() {
        return spawn;
    }

    @Override
    public void setSpawn(Vector3 pos) {
        this.spawn = pos;
        this.levelDBData.setSpawnX(pos.getFloorX());
        this.levelDBData.setSpawnY(pos.getFloorY());
        this.levelDBData.setSpawnZ(pos.getFloorZ());
    }

    @Override
    public Map<Long, ? extends FullChunk> getLoadedChunks() {
        return chunks;
    }

    @Override
    public void doGarbageCollection() {

    }

    /*@PowerNukkitOnly
    @Override
    public int getMaximumLayer() {
        return 1;
    }*/


    public static String getProviderName() {
        return "leveldb";
    }

    public static byte getProviderOrder() {
        return ORDER_YZX;
    }

    public static boolean usesChunkSection() {
        return true;
    }

    private byte[] getDbValue(LevelDBKeys key, byte subKey, int x, int z) {
        return this.db.get(key.getSubKey(x, z, subKey));
    }
    private byte[] getDbValue(LevelDBKeys key, int x, int z) {
        return this.db.get(key.getKey(x, z));
    }

    private byte[] getDbValue(LevelDBKeys key, byte subKey, int x, int z, int dimension) {
        if (dimension == Level.DIMENSION_OVERWORLD) {
            return this.getDbValue(key, subKey, x, z);
        }
        return this.db.get(key.getSubKeyForDimension(x, z, dimension, subKey));
    }
    private byte[] getDbValue(LevelDBKeys key, int x, int z, int dimension) {
        if (dimension == Level.DIMENSION_OVERWORLD) {
            return this.getDbValue(key, x, z);
        }
        return this.db.get(key.getKeyForDimension(x, z, dimension));
    }

    private void putDbValue(byte[] key, byte[] value) {
        if (value == null) {
            this.db.delete(key);
        } else {
            this.db.put(key, value);
        }
    }

    private void putDbValue(LevelDBKeys key, byte subKey, int x, int z, byte[] value) {
        putDbValue(key.getSubKey(x, z, subKey), value);
    }

    private void putDbValue(LevelDBKeys key, int x, int z, byte[] value) {
        putDbValue(key.getKey(x, z), value);
    }

    private void putDbValue(LevelDBKeys key, byte subKey, int x, int z, int dimension, byte[] value) {
        if (dimension == Level.DIMENSION_OVERWORLD) {
            this.putDbValue(key, subKey, x, z, value);
        } else {
            putDbValue(key.getSubKeyForDimension(x, z, dimension, subKey), value);
        }
    }

    private void putDbValue(LevelDBKeys key, int x, int z, int dimension, byte[] value) {
        if (dimension == Level.DIMENSION_OVERWORLD) {
            this.putDbValue(key, x, z, value);
        } else {
            putDbValue(key.getKeyForDimension(x, z, dimension), value);
        }
    }


    private byte[] computeDBValueIfAbsent(byte[] key, Callable<byte[]> computeFunction) {
        byte[] value = this.db.get(key);
        if (value == null) {
            try {
                value = computeFunction.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (value != null) {
                putDbValue(key, value);
            }
        }
        return value;
    }

    private byte[] computeDBValueIfAbsent(LevelDBKeys key, int x, int z, Callable<byte[]> computeFunction) {
        return computeDBValueIfAbsent(key.getKey(x, z), computeFunction);
    }

    private byte[] computeDBValueIfAbsent(LevelDBKeys key, int x, int z, int dimension, Callable<byte[]> computeFunction) {
        if (dimension == Level.DIMENSION_OVERWORLD) {
            return this.computeDBValueIfAbsent(key, x, z, computeFunction);
        }
        return computeDBValueIfAbsent(key.getKeyForDimension(x, z, dimension), computeFunction);
    }

    private byte getChunkVersion(int x, int z, int dimension) {
        return computeDBValueIfAbsent(LevelDBKeys.CHUNK_VERSION, x, z, dimension, () -> new byte[]{CHUNK_VERSION})[0];
    }

    private LevelDBChunkData getChunkData(int x, int z, int dimension) throws IOException {

        final AtomicReference<LevelDBChunkData> chunkData = new AtomicReference<>(null);

        byte[] data3D = computeDBValueIfAbsent(LevelDBKeys.DATA_3D, x, z, dimension, () -> {
            chunkData.set(new LevelDBChunkData(new LevelDBChunkHeightMap(), new LevelDBChunkBiomeMap()));
            return chunkData.get().write();
        });

        if (chunkData.get() == null) {
            chunkData.set(LevelDBChunkData.read(data3D));
        }

        return chunkData.get();
    }

    private Set<CompoundTag> getBlockEntitiesNBT(int x, int z, int dimension) throws IOException {
        return LevelDBCompoundSet.read(getDbValue(LevelDBKeys.BLOCK_ENTITY, x, z, dimension));
    }

    private Set<CompoundTag> getEntitiesNBT(int x, int z, int dimension) throws IOException {
        return LevelDBCompoundSet.read(getDbValue(LevelDBKeys.ENTITY, x, z, dimension));
    }

    public static boolean isValid(String path) {
        boolean isValid = (new File(path + "/level.dat").exists()) && new File(path + "/db/").isDirectory();
        return isValid;
    }

    public static void generate(String path, String name, long seed, Class<? extends Generator> generator) throws IOException {
        generate(path, name, seed, generator, new HashMap<>());
    }

    @PowerNukkitDifference(since = "1.4.0.0-PN", info = "Fixed resource leak")
    public static void generate(String path, String name, long seed, Class<? extends Generator> generator, Map<String, String> options) throws IOException {
        File dbDir = new File(path + "/db");
        if (!dbDir.exists() && !dbDir.mkdirs()) {
            throw new IOException("Could not create the LevelDB database directory " + dbDir);
        }
        DirectDB db = LevelDB.PROVIDER.open(dbDir, new Options().createIfMissing(true));
        db.close();
        LevelDBData levelDBData = new LevelDBData(new File(path + "/level.dat"));
        levelDBData.setLastPlayed(System.currentTimeMillis() / 1000);
        levelDBData.setLevelName(name);
        levelDBData.setRandomSeed(seed);
        levelDBData.save();

    }

}
