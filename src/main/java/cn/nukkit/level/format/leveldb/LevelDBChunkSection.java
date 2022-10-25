package cn.nukkit.level.format.leveldb;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.blockstate.BlockStateRegistry;
import cn.nukkit.level.Position;
import cn.nukkit.level.format.ChunkSection;
import cn.nukkit.level.format.generic.EmptyChunkSection;
import cn.nukkit.level.format.leveldb.palette.Palette;
import cn.nukkit.level.format.leveldb.util.LevelDBBlockUtils;
import cn.nukkit.level.util.PalettedBlockStorage;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.utils.BedrockMappingUtil;
import cn.nukkit.utils.BinaryStream;
import cn.nukkit.utils.ChunkException;
import cn.nukkit.utils.Zlib;
import io.netty.buffer.*;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.*;

@Log4j2
public class LevelDBChunkSection implements ChunkSection {

    @PowerNukkitOnly
    public static final int STREAM_STORAGE_VERSION = 8;
    private static final int BLOCK_ID_MASK = 0x00FF;
    private static final int BLOCK_ID_EXTRA_MASK = 0xFF00;
    private static final int BLOCK_ID_FULL = BLOCK_ID_MASK | BLOCK_ID_EXTRA_MASK;
    private int sectionY;
    private final List<Layer> layers;

    protected byte[] blockLight;
    protected byte[] skyLight;
    protected byte[] compressedLight;
    protected boolean hasBlockLight;
    protected boolean hasSkyLight;

    public LevelDBChunkSection(int sectionY) {
        this.sectionY = sectionY;
        this.layers = new ArrayList<>();
    }

    @Override
    public int getY() {
        return sectionY;
    }

    public void setY(int sectionY) {
        this.sectionY = sectionY;
    }

    @Since("1.3.0.0-PN")
    @PowerNukkitOnly("Needed for level backward compatibility")
    @Override
    public int getContentVersion() {
        return 12;
    }

    @Override
    public BlockID getBlockId(int x, int y, int z) {
        return getLayer(0).getBlockEntryAt(x, y, z).getBlockId();
    }

    @PowerNukkitOnly
    @Override
    public BlockID getBlockId(int x, int y, int z, int layer) {
        return getLayer(layer).getBlockEntryAt(x, y, z).getBlockId();
    }

    @Override
    public void setBlockId(int x, int y, int z, BlockID id) {
        getLayer(0).setBlockEntryAt(x, y, z, BlockState.of(id));
    }

    @Override
    public int getBlockData(int x, int y, int z) {
        return getLayer(0).getBlockEntryAt(x, y, z).getSignedBigDamage();
    }

    @PowerNukkitOnly
    @Override
    public int getBlockData(int x, int y, int z, int layer) {
        return getLayer(layer).getBlockEntryAt(x, y, z).getSignedBigDamage();
    }

    @Override
    public void setBlockData(int x, int y, int z, int data) {
        getLayer(0).setBlockEntryAt(x, y, z, getBlockState(x, y, z).withData(data));
    }

    @PowerNukkitOnly
    @Override
    public void setBlockData(int x, int y, int z, int layer, int data) {
        getLayer(layer).setBlockEntryAt(x, y, z, getBlockState(x, y, z).withData(data));
    }

    @PowerNukkitOnly
    @Nonnull
    @Override
    public Block getAndSetBlock(int x, int y, int z, int layer, Block block) {
        Block oldBlock = getLayer(layer).getBlockEntryAt(x, y, z).getBlock();
        getLayer(layer).setBlockEntryAt(x, y, z, block.getCurrentState());
        return oldBlock;
    }

    @Nonnull
    @Override
    public Block getAndSetBlock(int x, int y, int z, Block block) {
        Block oldBlock = getLayer(0).getBlockEntryAt(x, y, z).getBlock();
        getLayer(0).setBlockEntryAt(x, y, z, block.getCurrentState());
        return oldBlock;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockState getAndSetBlockState(int x, int y, int z, int layer, BlockState state) {
        BlockState oldState = getLayer(layer).getBlockEntryAt(x, y, z);
        getLayer(layer).setBlockEntryAt(x, y, z, state);
        return oldState;
    }

    @PowerNukkitOnly
    @Override
    public void setBlockId(int x, int y, int z, int layer, BlockID id) {
        getLayer(layer).setBlockEntryAt(x, y, z, BlockState.of(id));
    }

    @PowerNukkitOnly
    public boolean setBlockAtLayer(int x, int y, int z, int layer, BlockID blockId) {
        return setBlockStateAtLayer(x, y, z, layer, BlockState.of(blockId));
    }

    public boolean setBlock(int x, int y, int z, BlockID blockId) {
        return setBlockStateAtLayer(x, y, z, 0, BlockState.of(blockId));
    }

    public boolean setBlock(int x, int y, int z, BlockID blockId, int meta) {
        return setBlockStateAtLayer(x, y, z, 0, BlockState.of(blockId, meta));
    }

    @PowerNukkitOnly
    public boolean setBlockAtLayer(int x, int y, int z, int layer, BlockID blockId, int meta) {
        return setBlockStateAtLayer(x, y, z, layer, BlockState.of(blockId, meta));
    }

    // TODO: 2022/3/21 Implement lighting calculations

    @Override
    public int getBlockSkyLight(int x, int y, int z) {
        if (this.skyLight == null) {
            if (!hasSkyLight) {
                return 0;
            } else if (compressedLight == null) {
                return 15;
            }
            this.skyLight = getSkyLightArray();
        }
        int sl = this.skyLight[(y << 7) | (z << 3) | (x >> 1)] & 0xff;
        if ((x & 1) == 0) {
            return sl & 0x0f;
        }
        return sl >> 4;
    }

    @Override
    public void setBlockSkyLight(int x, int y, int z, int level) {
        if (this.skyLight == null) {
            if (hasSkyLight && compressedLight != null) {
                this.skyLight = getSkyLightArray();
            } else if (level == (hasSkyLight ? 15 : 0)) {
                return;
            } else {
                this.skyLight = new byte[2048];
                if (hasSkyLight) {
                    Arrays.fill(this.skyLight, (byte) 0xFF);
                }
            }
        }
        int i = (y << 7) | (z << 3) | (x >> 1);
        int old = this.skyLight[i] & 0xff;
        if ((x & 1) == 0) {
            this.skyLight[i] = (byte) ((old & 0xf0) | (level & 0x0f));
        } else {
            this.skyLight[i] = (byte) (((level & 0x0f) << 4) | (old & 0x0f));
        }
    }

    @Override
    public int getBlockLight(int x, int y, int z) {
        if (blockLight == null && !hasBlockLight) return 0;
        this.blockLight = getLightArray();
        int l = blockLight[(y << 7) | (z << 3) | (x >> 1)] & 0xff;
        if ((x & 1) == 0) {
            return l & 0x0f;
        }
        return l >> 4;
    }

    @Override
    public void setBlockLight(int x, int y, int z, int level) {
        if (this.blockLight == null) {
            if (hasBlockLight) {
                this.blockLight = getLightArray();
            } else if (level == 0) {
                return;
            } else {
                this.blockLight = new byte[2048];
            }
        }
        int i = (y << 7) | (z << 3) | (x >> 1);
        int old = this.blockLight[i] & 0xff;
        if ((x & 1) == 0) {
            this.blockLight[i] = (byte) ((old & 0xf0) | (level & 0x0f));
        } else {
            this.blockLight[i] = (byte) (((level & 0x0f) << 4) | (old & 0x0f));
        }
    }

    @Override
    public byte[] getSkyLightArray() {
        if (skyLight != null) {
            return skyLight.clone();
        }

        if (!hasSkyLight) {
            return new byte[EmptyChunkSection.EMPTY_LIGHT_ARR.length];
        }

        if (compressedLight != null && inflate() && skyLight != null) {
            return skyLight.clone();
        }

        return EmptyChunkSection.EMPTY_SKY_LIGHT_ARR.clone();
    }

    @Override
    public byte[] getLightArray() {
        if (blockLight != null) {
            return blockLight.clone();
        }

        if (hasBlockLight && compressedLight != null && inflate() && blockLight != null) {
            return blockLight.clone();
        }

        return new byte[EmptyChunkSection.EMPTY_LIGHT_ARR.length];
    }

    private boolean inflate() {
        try {
            if (compressedLight != null && compressedLight.length != 0) {
                byte[] inflated = Zlib.inflate(compressedLight);
                blockLight = Arrays.copyOfRange(inflated, 0, 2048);
                if (inflated.length > 2048) {
                    skyLight = Arrays.copyOfRange(inflated, 2048, 4096);
                } else {
                    skyLight = new byte[2048];
                    if (hasSkyLight) {
                        Arrays.fill(skyLight, (byte) 0xFF);
                    }
                }
                compressedLight = null;
            } else {
                blockLight = new byte[2048];
                skyLight = new byte[2048];
                if (hasSkyLight) {
                    Arrays.fill(skyLight, (byte) 0xFF);
                }
            }
            return true;
        } catch (IOException e) {
            log.error("Failed to decompress a chunk section", e);
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        return layers.isEmpty();
    }

    @Since("1.4.0.0-PN")
    @Override
    public void writeTo(BinaryStream stream, int protocol) {
        stream.putByte((byte) STREAM_STORAGE_VERSION);
        stream.putByte((byte) getLayers().size());

        List<Layer> layers = getLayers();
        for (Layer layer : layers) {
            layer.writeTo(stream, protocol);
        }
    }

    @PowerNukkitOnly
    @Override
    public int getMaximumLayer() {
        return 0;
    }

    @PowerNukkitOnly
    @Nonnull
    @Override
    public CompoundTag toNBT() {
        return null;
    }

    @Nonnull
    @Override
    public ChunkSection copy() {
        return null;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public boolean setBlockStateAtLayer(int x, int y, int z, int layer, BlockState state) {
        return false;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getBlockChangeStateAbove(int x, int y, int z) {
        return 0;
    }

    /**
     * Retrieve all of the {@link Layer}s of this subchunk.
     *
     * @return the {@link List} of {@link Layer}s this subchunk holds.
     */
    public List<Layer> getLayers() {
        return Collections.unmodifiableList(this.layers);
    }

    /**
     * Retrieve a specific {@link Layer} in this subchunk.
     * If the layer does not exist, it should create the layer
     *
     * @param index block layer index
     * @return {@link Layer}
     */
    public Layer getLayer(int index) {
        while (index >= this.getLayers().size()) {
            Palette<BlockState> blockPalette = new Palette<BlockState>();
            blockPalette.addEntry(BlockState.AIR);    // ensure the palette has air

            Layer blockLayer = new Layer(blockPalette);
            this.addLayer(blockLayer);
        }
        return this.layers.get(index);
    }

    /**
     * Add a new {@link Layer} to this subchunk.
     *
     * @param layer The {@link Layer} to add
     */
    public void addLayer(Layer layer) {
        this.layers.add(layer);
    }

    public byte[] write() throws IOException {

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();

        try {
            // Write SectionVersion
            byteBuf.writeByte(8);
            byteBuf.writeByte(layers.size());
            for (Layer layer : layers) {
                layer.write(byteBuf);
            }

            byte[] data = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(data);

            return data;
        } finally {
            byteBuf.release();
        }
    }


    public static LevelDBChunkSection read(byte[] data, int sectionY) throws IOException {
        ByteBuf byteBuf = Unpooled.wrappedBuffer(data);
        LevelDBChunkSection chunkSection = new LevelDBChunkSection(sectionY);
        int sectionVersion = byteBuf.readByte();
        int amountOfLayers;

        switch (sectionVersion) {
            case 9:
                amountOfLayers = byteBuf.readByte();
                byte cy = byteBuf.readByte();
                break;
            case 8:
                amountOfLayers = byteBuf.readByte();
                break;
            case 1:
                amountOfLayers = 1;
                break;
            default:
                throw new ChunkException("Unknown sub chunk version: v" + sectionVersion);
        }


        for (int layerIndex = 0; layerIndex < amountOfLayers; layerIndex++) {
            Layer layer = Layer.read(byteBuf);
            chunkSection.addLayer(layer);
        }

        return chunkSection;
    }


    public static class Layer {

        private final Palette<BlockState> palette;
        private final int[] blocks = new int[4096];

        public Layer(Palette<BlockState> palette) {
            this.palette = palette;
        }

        /**
         * Retrieve the {@link Palette} used for this layer.
         *
         * @return the {@link Palette} used for this layer.
         */
        public Palette<BlockState> getPalette() {
            return this.palette;
        }

        /**
         * Retrieve the {@link BlockState} of a block at the given coordinates.
         *
         * @param x x coordinate
         * @param y y coordinate
         * @param z z coordinate
         * @return the {@link BlockState} of the block at the coordinates
         */
        public BlockState getBlockEntryAt(int x, int y, int z) {
            if (this.palette.size() == 0) {
                // if the palette is empty, then add an air entry in order to make this.blocks accurately return air for all 0s.
                this.palette.addEntry(BlockState.AIR);
            }

            int block = this.blocks[getBlockIndex(x, y, z)];

            BlockState blockState = this.palette.getEntry(block);

            if (blockState == null) {
                log.warn("Could not find blockState for ID " + block + " in Palette " + this.palette.size());
                return BlockState.AIR;
            }
            return blockState;
        }

        /**
         * Set the coordinates of the blocklayer to a new {@link BlockState}.
         *
         * @param x     x coordinate
         * @param y     y coordinate
         * @param z     z coordinate
         * @param entry new entry to set the block to
         */
        public void setBlockEntryAt(int x, int y, int z, BlockState entry) {
            if (this.palette.size() == 0) {
                // If the palette is empty, then add an air entry to make every 0 in this.blocks return air.
                // Otherwise, when this method calls this.palette.add(entry), every 0 in this.blocks will be assigned that block.
                this.palette.addEntry(BlockState.AIR);
            }

            this.palette.addEntry(entry);
            this.blocks[getBlockIndex(x, y, z)] = this.palette.getPaletteIndex(entry);
        }

        /**
         * Resize modifies the block layer values and removes unused block palette values.
         */
        public void resize() {
            // Get all the palette indexes being used
            Map<Integer, BlockState> usedEntries = new HashMap<>();
            for (int paletteIndex : this.blocks) {
                usedEntries.put(paletteIndex, this.palette.getEntry(paletteIndex));
            }

            // Remove unused palette entries
            Iterator<BlockState> entryIterator = new HashSet<>(this.palette.getEntries()).iterator();
            while (entryIterator.hasNext()) {
                BlockState entry = entryIterator.next();
                int paletteIndex = this.palette.getPaletteIndex(entry);

                // Air occupies the first element of the block palette and CANNOT be removed or else empty elements of
                // this.blocks will not resolve to air. Any other palette entry can be removed.
                if (!usedEntries.containsKey(paletteIndex) && entry.getBlockId() != (BlockID.AIR)) {
                    entryIterator.remove();
                    this.palette.removeEntry(entry);
                }
            }

            // Shift entries in the palette as far down as possible
            this.palette.resize();

            // Update our blocks with the new palette indexes
            for (int i = 0; i < this.blocks.length; i++) {
                this.blocks[i] = this.palette.getPaletteIndex(usedEntries.get(this.blocks[i]));
            }
        }

        public void writeTo(BinaryStream stream, int protocol) {
            PalettedBlockStorage blockStorage = PalettedBlockStorage.createFromBlockPalette();

            for (int x = 0; x < 16; x++) {
                for (int y = 0; y < 16; y++) {
                    for (int z = 0; z < 16; z++) {
                        blockStorage.setBlock(x, y, z, getBlockEntryAt(x, y, z).getRuntimeId());
                    }
                }
            }

            blockStorage.writeTo(stream, protocol);
        }

        private static int getBlockIndex(int x, int y, int z) {
            return (x << 8) | (z << 4) | y;
        }

        public void write(ByteBuf byteBuf) throws IOException {
            resize();


            int bitsPerBlock = Math.max((int) Math.ceil(Math.log(getPalette().getEntries().size()) / Math.log(2)), 1);
            int blocksPerWord = 32 / bitsPerBlock;
            int wordsPerChunk = (int) Math.ceil(4096d / blocksPerWord);

            byteBuf.writeByte((bitsPerBlock << 1) | 1);

            int pos = 0;
            for (int chunk = 0; chunk < wordsPerChunk; chunk++) {
                int word = 0;
                for (int block = 0; block < blocksPerWord; block++) {
                    if (pos >= 4096) {
                        break;
                    }

                    word |= getPalette().getPaletteIndex(getBlockEntryAt(pos >> 8, pos & 15, (pos >> 4) & 15)) << (bitsPerBlock * block);
                    pos++;
                }
                byteBuf.writeIntLE(word);
            }

            writePalette(byteBuf, getPalette());
        }

        public static Layer read(ByteBuf byteBuf) throws IOException {
            int bitsPerBlock = byteBuf.readByte() >> 1;
            int blocksPerWord = 32 / bitsPerBlock;
            int wordsPerChunk = (int) Math.ceil(4096d / blocksPerWord); // there are 4096 blocks in a chunk stored in x words

            // We want to read the palette first so that we can translate what blocks are immediately.
            int chunkBlocksIndex = byteBuf.readerIndex();
            byteBuf.setIndex(chunkBlocksIndex + (wordsPerChunk * 4), byteBuf.writerIndex());

            Palette<BlockState> palette = readPalette(byteBuf);
            int endPaletteIndex = byteBuf.readerIndex(); // we jump to this index after reading the blocks

            // Go back and parse the blocks.
            byteBuf.setIndex(chunkBlocksIndex, byteBuf.writerIndex());
            Layer layer = new Layer(palette);

            int pos = 0;
            for (int chunk = 0; chunk < wordsPerChunk; chunk++) {
                int word = byteBuf.readIntLE();  // This integer can store multiple minecraft blocks.
                for (int block = 0; block < blocksPerWord; block++) {
                    if (pos >= 4096) {
                        break;
                    }

                    int paletteIndex = (word >> (pos % blocksPerWord) * bitsPerBlock) & ((1 << bitsPerBlock) - 1);
                    BlockState blockState = palette.getEntry(paletteIndex);
                    if (blockState == null) {
                        //paletteIndex = -1;
                        throw new IllegalStateException("Loaded Palette does not contain blockState for " + paletteIndex + " " + palette.size() + "@" + new Position(pos >> 8, pos & 15, (pos >> 4) & 15));
                    } else {
                        if (blockState instanceof UnknownBlockState) {
                            layer.setBlockEntryAt(pos >> 8, pos & 15, (pos >> 4) & 15, BlockState.of(BlockID.UNKNOWN));
                        } else {
                            layer.setBlockEntryAt(pos >> 8, pos & 15, (pos >> 4) & 15, blockState);
                        }

                    }

                    pos++;
                }
            }

            // Go back to the end of the palette to prepare for the next layer
            byteBuf.setIndex(endPaletteIndex, byteBuf.writerIndex());

            return layer;
        }

        private static Palette<BlockState> readPalette(ByteBuf byteBuf) throws IOException {
            Palette<BlockState> palette = new Palette<BlockState>();
            int paletteLength = byteBuf.readIntLE();
            for (int i = 0; i < paletteLength; i++) {
                CompoundTag compound = (CompoundTag) NBTIO.readTag(new ByteBufInputStream(byteBuf), ByteOrder.LITTLE_ENDIAN, false);
                BlockState blockState = LevelDBBlockUtils.nbt2BlockState(compound);
                if (blockState.getBlockId() == BlockStateRegistry.getBlockId("minecraft:unknown")) {
                    blockState = new UnknownBlockState(compound, blockState.getBlockId());
                }
                palette.addEntry(blockState, true);

            }
            return palette;
        }

        public static void writePalette(ByteBuf buffer, Palette<BlockState> palette) throws IOException {
            Set<BlockState> entries = palette.getEntries();
            buffer.writeIntLE(entries.size());
            for (BlockState data : entries) {
                boolean unknown = data instanceof UnknownBlockState;
                NBTIO.write(unknown ? ((UnknownBlockState) data).getCompoundTag() : LevelDBBlockUtils.blockState2Nbt(data), new ByteBufOutputStream(buffer), ByteOrder.LITTLE_ENDIAN, false);
            }
        }

        private static void writeNetworkPalette(BinaryStream stream, Palette<BlockState> palette, int protocol) {
            Set<BlockState> entries = palette.getEntries();
            stream.putVarInt(entries.size());
            for (BlockState data : entries) {
                stream.putVarInt(
                        BedrockMappingUtil.translateBlockRuntimeId(
                                protocol,
                                data.getRuntimeId(),
                                true
                        )
                );
            }
        }
    }

}
