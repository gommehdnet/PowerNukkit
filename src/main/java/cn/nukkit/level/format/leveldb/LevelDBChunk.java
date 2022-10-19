package cn.nukkit.level.format.leveldb;

import cn.nukkit.level.DimensionEnum;
import cn.nukkit.level.format.ChunkSection;
import cn.nukkit.level.format.LevelProvider;
import cn.nukkit.level.format.generic.BaseChunk;
import cn.nukkit.level.format.generic.EmptyChunkSection;
import cn.nukkit.level.format.leveldb.data.LevelDBChunkBiomeMap;
import cn.nukkit.level.format.leveldb.data.LevelDBChunkHeightMap;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.utils.ChunkException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class LevelDBChunk extends BaseChunk {

    private final int dimension;
    @Getter
    @Setter
    private byte version;


    @Getter
    @Setter
    private LevelDBChunkBiomeMap biomeMap = new LevelDBChunkBiomeMap();
    @Getter
    @Setter
    private LevelDBChunkHeightMap heightMap = new LevelDBChunkHeightMap();
    private LevelProvider levelProvider;

    protected boolean terrainPopulated = false;
    protected boolean terrainGenerated = false;

    public LevelDBChunk(LevelProvider levelProvider, int x, int z, int dimension) {
        this.dimension = dimension;
        this.levelProvider = levelProvider;
        this.providerClass = levelProvider.getClass();

        super.setX(x);
        super.setZ(z);
        super.sections = new ChunkSection[getChunkSectionCount()];
        System.arraycopy(getChunkSectionCount() == 24 ? EmptyChunkSection.EMPTY_24 : EmptyChunkSection.EMPTY,
                0, this.sections, 0, getChunkSectionCount());

        super.baseY = dimension == 0 ? -64 : 0;

        if(levelProvider instanceof LevelDBFormat) {
            LevelDBFormat levelDB = (LevelDBFormat) levelProvider;
            this.terrainGenerated = levelDB.isChunkGenerated(x, z);
            this.terrainPopulated = levelDB.isChunkPopulated(x, z);
        }
    }


    public int getChunkSectionCount() {
        return dimension == 0 ? 24 : 16;
    }


    @Override
    public boolean setSection(float fY, ChunkSection section) {
        if (!section.hasBlocks()) {
            this.sections[(int) fY] = EmptyChunkSection.EMPTY_24[(int) fY];
        } else {
            this.sections[(int) fY] = section;
        }
        setChanged();
        return true;
    }


    @Override
    public LevelProvider getProvider() {
        return levelProvider;
    }

    @Override
    public void setProvider(LevelProvider provider) {
        this.levelProvider = provider;
        super.setProvider(provider);

    }



    @Override
    public boolean isPopulated() {
        return this.terrainPopulated;
    }

    @Override
    public void setPopulated() {
        this.setPopulated(true);
    }

    @Override
    public void setPopulated(boolean value) {
        this.terrainPopulated = value;
        if (this.provider != null && this.provider instanceof LevelDBFormat) {
            ((LevelDBFormat) this.provider).setChunkPopulated(this.getX(), this.getZ(), value);
        }
    }

    @Override
    public boolean isGenerated() {
        return this.terrainGenerated;
    }

    @Override
    public void setGenerated() {
        this.setGenerated(true);
    }

    @Override
    public void setGenerated(boolean value) {
        this.terrainGenerated = value;
        if(this.provider != null && this.provider instanceof LevelDBFormat) {
            ((LevelDBFormat) this.provider).setChunkGenerated(this.getX(), this.getZ(), value);
        }
    }

    @Override
    public int getHeightMap(int x, int z) {
        return this.heightMap.getHighestBlockAt(x, z);
    }

    @Override
    public void setHeightMap(int x, int z, int value) {
        this.heightMap.setHighestBlockAt(x, z, value);
    }

    @Override
    public byte[] getHeightMapArray() {
        byte[] data = new byte[512];
        ByteBuf buffer = Unpooled.wrappedBuffer(data);
        buffer.writerIndex(0);
        try {
            for (int height : heightMap.array()) {
                buffer.writeShortLE(height);
            }
            return data;
        } finally {
            buffer.release();
        }
    }

    @Override
    public int getBiomeId(int x, int z) {
        LevelDBChunkBiomeMap.SubChunk subBiomeMap = this.biomeMap.getTopSubChunk();
        if (subBiomeMap == null) {
            return 0;
        } else {
            return Math.max(subBiomeMap.getBiomeAt(x, 0, z), 0);
        }
    }

    public int getBiomeIdInSection(int section, int x, int y, int z) {
        LevelDBChunkBiomeMap.SubChunk subBiomeMap = this.biomeMap.getSubChunks().length > section ? this.biomeMap.getSubChunks()[section] : null;
        if (subBiomeMap == null) {
            return 0;
        } else {
            return Math.max(subBiomeMap.getBiomeAt(x, y, z), 0);
        }
    }

    @Override
    public void setBiomeId(int x, int z, byte biomeId) {
        for (LevelDBChunkBiomeMap.SubChunk each : this.biomeMap.getSubChunks()) {
            if (each == null) {
                continue;
            }
            for (int i = (dimension == 0 ? 0 : -64); i < (dimension == 0 ? 256 : 320); i++) {
                each.setBiomeAt(x, i, z, biomeId);
            }
        }
    }

    @Override
    public byte[] getBiomeIdArray() {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.ioBuffer();
        try {
            LevelDBChunkBiomeMap.SubChunk lastSubChunkBiomeMap = null;
            for (LevelDBChunkBiomeMap.SubChunk subChunkBiomeMap : biomeMap.getSubChunks()) {
                if (subChunkBiomeMap.getPalette().getEntries().size() == 0) {
                    throw new ChunkException("biome sub chunk has no biomes present");
                }
                int bitsPerBlock = (int) Math.ceil(Math.log(subChunkBiomeMap.getPalette().getEntries().size()) / Math.log(2));
                int blocksPerWord = 0;
                int wordsPerChunk = 0;
                if (subChunkBiomeMap.equals(lastSubChunkBiomeMap)) {
                    buffer.writeByte(-1);
                    continue;
                }
                if (bitsPerBlock > 0) {
                    blocksPerWord = 32 / bitsPerBlock;
                    wordsPerChunk = (int) Math.ceil(4096d / blocksPerWord);
                }
                buffer.writeByte((bitsPerBlock << 1) | 1);
                int pos = 0;
                for (int i = 0; i < wordsPerChunk; i++) {
                    int word = 0;
                    for (int block = 0; block < blocksPerWord; block++) {
                        if (pos >= 4096) {
                            break;
                        }
                        word |= subChunkBiomeMap.getPalette().getPaletteIndex(subChunkBiomeMap.getBiomeAt(pos >> 8, (pos >> 4) & 15, pos & 15)) << (bitsPerBlock * block);
                        pos++;
                    }
                    buffer.writeIntLE(word);
                }

                if (bitsPerBlock > 0) {
                    buffer.writeIntLE(subChunkBiomeMap.getPalette().getEntries().size());
                }
                for (int i = 0; i < subChunkBiomeMap.getPalette().getEntries().size(); i++) {
                    buffer.writeIntLE(subChunkBiomeMap.getPalette().getEntry(i));
                }
                lastSubChunkBiomeMap = subChunkBiomeMap;
            }
            byte[] data = new byte[buffer.readableBytes()];
            buffer.readBytes(data);
            return data;
        } finally {
            buffer.release();
        }
    }


    public void addInitialEntityNbt(CompoundTag nbt) {
        if (NBTentities == null) {
            NBTentities = new ArrayList<>();
        }
        NBTentities.add(nbt);
    }

    public void addInitialBlockEntityNbt(CompoundTag nbt) {
        if (NBTtiles == null) {
            NBTtiles = new ArrayList<>();
        }
        NBTtiles.add(nbt);
    }


    @Override
    public byte[] toBinary() {
        return new byte[0];
    }

}
