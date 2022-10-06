package cn.nukkit.level.format.leveldb;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.level.format.ChunkSection;
import cn.nukkit.level.format.leveldb.palette.Palette;
import cn.nukkit.level.format.leveldb.util.LevelDBBlockUtils;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.utils.BinaryStream;
import cn.nukkit.utils.ChunkException;
import io.netty.buffer.*;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.*;

public class LevelDBChunkSection implements ChunkSection {
    private int sectionY;
    private final List<Layer> layers;

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

    @Override
    public int getBlockId(int x, int y, int z) {
        return 0;
    }

    @PowerNukkitOnly
    @Override
    public int getBlockId(int x, int y, int z, int layer) {
        return 0;
    }

    @Override
    public void setBlockId(int x, int y, int z, int id) {

    }

    @Override
    public int getBlockData(int x, int y, int z) {
        return 0;
    }

    @PowerNukkitOnly
    @Override
    public int getBlockData(int x, int y, int z, int layer) {
        return 0;
    }

    @Override
    public void setBlockData(int x, int y, int z, int data) {

    }

    @PowerNukkitOnly
    @Override
    public void setBlockData(int x, int y, int z, int layer, int data) {

    }

    @Override
    public int getFullBlock(int x, int y, int z) {
        return 0;
    }

    @PowerNukkitOnly
    @Override
    public int getFullBlock(int x, int y, int z, int layer) {
        return 0;
    }

    @PowerNukkitOnly
    @Nonnull
    @Override
    public Block getAndSetBlock(int x, int y, int z, int layer, Block block) {
        return null;
    }

    @Nonnull
    @Override
    public Block getAndSetBlock(int x, int y, int z, Block block) {
        return null;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockState getAndSetBlockState(int x, int y, int z, int layer, BlockState state) {
        return null;
    }

    @PowerNukkitOnly
    @Override
    public void setBlockId(int x, int y, int z, int layer, int id) {

    }

    @Override
    public boolean setFullBlockId(int x, int y, int z, int fullId) {
        return false;
    }

    @PowerNukkitOnly
    @Override
    public boolean setFullBlockId(int x, int y, int z, int layer, int fullId) {
        return false;
    }

    @PowerNukkitOnly
    @Override
    public boolean setBlockAtLayer(int x, int y, int z, int layer, int blockId) {
        return false;
    }

    @Override
    public boolean setBlock(int x, int y, int z, int blockId) {
        return false;
    }

    @Override
    public boolean setBlock(int x, int y, int z, int blockId, int meta) {
        return false;
    }

    @PowerNukkitOnly
    @Override
    public boolean setBlockAtLayer(int x, int y, int z, int layer, int blockId, int meta) {
        return false;
    }

    @Override
    public int getBlockSkyLight(int x, int y, int z) {
        return 0;
    }

    @Override
    public void setBlockSkyLight(int x, int y, int z, int level) {

    }

    @Override
    public int getBlockLight(int x, int y, int z) {
        return 0;
    }

    @Override
    public void setBlockLight(int x, int y, int z, int level) {

    }

    @Override
    public byte[] getSkyLightArray() {
        return new byte[0];
    }

    @Override
    public byte[] getLightArray() {
        return new byte[0];
    }

    @Override
    public boolean isEmpty() {
        return layers.isEmpty();
    }

    @Since("1.4.0.0-PN")
    @Override
    public void writeTo(BinaryStream stream, int protocol) {

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
        /*if (index == 0) {
            if (layer0 == null) {
                return layer0 = layers.get(0);
            } else {
                return layer0;
            }
        }*/
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

        // Write SectionVersion
        byteBuf.writeByte(8);
        byteBuf.writeByte(layers.size());
        for (Layer layer : layers) {
            layer.write(byteBuf);
        }

        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);

        return data;
    }


    public static LevelDBChunkSection read(byte[] data, int sectionY) throws IOException {
        ByteBuf byteBuf = Unpooled.wrappedBuffer(data);
        LevelDBChunkSection chunkSection = new LevelDBChunkSection(sectionY);
        int sectionVersion = byteBuf.readByte();
        int amountOfLayers;
        switch (sectionVersion) {
            case 9:
                amountOfLayers = byteBuf.readByte();
                byteBuf.readByte();  // data driven heights
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
         * @return the {@link Palette} used for this layer.
         */
        public Palette<BlockState> getPalette() {
            return this.palette;
        }

        /**
         * Retrieve the {@link BlockState} of a block at the given coordinates.
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

            return this.palette.getEntry(this.blocks[getBlockIndex(x, y, z)]);
        }

        /**
         * Set the coordinates of the blocklayer to a new {@link BlockState}.
         * @param x x coordinate
         * @param y y coordinate
         * @param z z coordinate
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

        public void writeTo(BinaryStream stream) {
            resize();

            int bitsPerBlock = Math.max((int) Math.ceil(Math.log(palette.getEntries().size()) / Math.log(2)), 1);
            int blocksPerWord = 32 / bitsPerBlock;
            int wordsPerChunk = (int) Math.ceil(4096d / blocksPerWord);

            stream.putByte((byte) ((bitsPerBlock << 1) | 1));

            int pos = 0;
            for (int chunk = 0; chunk < wordsPerChunk; chunk++) {
                int word = 0;
                for (int block = 0; block < blocksPerWord; block++) {
                    if (pos >= 4096) {
                        break;
                    }

                    word |= palette.getPaletteIndex(getBlockEntryAt(pos >> 8, pos & 15, (pos >> 4) & 15)) << (bitsPerBlock * block);
                    pos++;
                }
                stream.putLInt(word);
            }
            writeNetworkPalette(stream, getPalette());
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
                    layer.setBlockEntryAt(pos >> 8, pos & 15, (pos >> 4) & 15, palette.getEntry(paletteIndex));

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
                palette.addEntry(LevelDBBlockUtils.nbt2BlockState(compound));
            }
            return palette;
        }
        public static void writePalette(ByteBuf buffer, Palette<BlockState> palette) throws IOException {
            Set<BlockState> entries = palette.getEntries();
            buffer.writeIntLE(entries.size());
            for (BlockState data : entries) {
                NBTIO.write(LevelDBBlockUtils.blockState2Nbt(data), new ByteBufOutputStream(buffer), ByteOrder.LITTLE_ENDIAN, false);
            }
        }
        private static void writeNetworkPalette(BinaryStream stream, Palette<BlockState> palette) {
            Set<BlockState> entries = palette.getEntries();
            stream.putVarInt(entries.size());
            for (BlockState data : entries) {
                stream.putVarInt(data.getRuntimeId());
            }
        }
    }

}
