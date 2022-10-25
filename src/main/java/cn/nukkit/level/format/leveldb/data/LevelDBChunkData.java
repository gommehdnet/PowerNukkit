package cn.nukkit.level.format.leveldb.data;

import cn.nukkit.level.format.leveldb.palette.IntPalette;
import cn.nukkit.utils.ChunkException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
@Data
public class LevelDBChunkData {

    private final LevelDBChunkHeightMap heightMap;
    private final LevelDBChunkBiomeMap biomeMap;


    public byte[] write() throws IOException {
        byte[] encodedBiomeMap = writeBiomeMap();

        byte[] data = new byte[512 + encodedBiomeMap.length];
        ByteBuf byteBuf = Unpooled.wrappedBuffer(data);

        byteBuf.writerIndex(0);
        try {
            for (int i = 0; i < 256; i++) {
                int z = i >> 4;
                int x = i & 15;
                try {
                    byteBuf.writeShortLE(this.heightMap.getHighestBlockAt(x, z));
                } catch (Exception e) {
                    throw new ChunkException("Error while writing chunkdata (i=" + i + ",x=" + x + ",z=" + z + ")", e);
                }
            }
            byteBuf.writeBytes(encodedBiomeMap);
            return data;
        } finally {
            byteBuf.release();
        }
    }

    private byte[] writeBiomeMap() throws IOException {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        try {
            LevelDBChunkBiomeMap.SubChunk lastSubChunkBiomeMap = null;
            for (LevelDBChunkBiomeMap.SubChunk subChunkBiomeMap : biomeMap.getSubChunks()) {
                if (subChunkBiomeMap == null) {
                    continue;
                }
                if (subChunkBiomeMap.getPalette().getEntries().size() == 0) {
                    //
                    byteBuf.writeByte(-1);
                    continue;
                    //throw new IOException("SubChunk has no biomes present");
                }

                int bitsPerBlock = (int) Math.ceil(Math.log(subChunkBiomeMap.getPalette().getEntries().size()) / Math.log(2));
                int blocksPerWord = 0;
                int wordsPerChunk = 0;

                if (subChunkBiomeMap.equals(lastSubChunkBiomeMap)) {
                    byteBuf.writeByte(-1);
                    continue;
                }

                if (bitsPerBlock > 0) {
                    blocksPerWord = 32 / bitsPerBlock;
                    wordsPerChunk = (int) Math.ceil(4096d / blocksPerWord);
                }

                byteBuf.writeByte((bitsPerBlock << 1) | 1);

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
                    byteBuf.writeIntLE(word);
                }

                if (bitsPerBlock > 0) {
                    byteBuf.writeIntLE(subChunkBiomeMap.getPalette().getEntries().size());
                }
                for (int i = 0, len = subChunkBiomeMap.getPalette().getEntries().size(); i < len; i++) {
                    byteBuf.writeIntLE(subChunkBiomeMap.getPalette().getEntry(i));
                }

                lastSubChunkBiomeMap = subChunkBiomeMap;
            }

            byte[] data = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(data);

            return data;
        } finally {
            byteBuf.release();
        }
    }


    public static LevelDBChunkData read(byte[] data) {
        ByteBuf byteBuf = Unpooled.copiedBuffer(data);
        try {

            LevelDBChunkHeightMap heightMap = new LevelDBChunkHeightMap();

            for (int i = 0; i < 256; i++) {
                int z = i >> 4;
                int x = i & 15;
                heightMap.setHighestBlockAt(x, z, byteBuf.readUnsignedShortLE());
            }

            LevelDBChunkBiomeMap biomeMap = new LevelDBChunkBiomeMap();


            LevelDBChunkBiomeMap.SubChunk[] chunkBiomeMapSubChunks = new LevelDBChunkBiomeMap.SubChunk[25];

            for (int i = 0; i < 25; i++) {
                chunkBiomeMapSubChunks[i] = new LevelDBChunkBiomeMap.SubChunk(new IntPalette());
            }

            LevelDBChunkBiomeMap.SubChunk lastBiomeSubChunk = null;

            int subChunkIndex = 0;
            while (byteBuf.readableBytes() > 0) {
                int bitsPerBlock = byteBuf.readByte() >> 1;

                // if the bits is -1, that means that we should just copy the last biome map.
                if (bitsPerBlock == -1) {
                    if (lastBiomeSubChunk == null) {
                        throw new ChunkException("Cannot use last biome subchunk if none exists.");
                    }
                    chunkBiomeMapSubChunks[subChunkIndex++] = lastBiomeSubChunk.clone();
                    continue;
                }

                // because the palette is written after the data, we keep a mental note of where the biome data is
                // so that we can construct the palette first.
                int biomeDataIndex = 0;
                int paletteLength = 1;  // for biomes, we assume by default that there is at least 1 biome present

                if (bitsPerBlock > 0) {
                    int blocksPerWord = 32 / bitsPerBlock;
                    int wordsPerChunk = (int) Math.ceil(4096d / blocksPerWord);

                    biomeDataIndex = byteBuf.readerIndex();

                    byteBuf.skipBytes(wordsPerChunk * 4);
                    paletteLength = byteBuf.readIntLE();
                }

                // Parse biome palette
                IntPalette palette = new IntPalette();
                for (int i = 0; i < paletteLength; i++) {
                    palette.addEntry(byteBuf.readIntLE());
                }

                int endOfPaletteIndex = byteBuf.readerIndex();

                // Begin constructing the biome map for this subchunk
                LevelDBChunkBiomeMap.SubChunk subChunkBiomeMap = new LevelDBChunkBiomeMap.SubChunk(palette);
                if (bitsPerBlock > 0) {
                    // Move our index back to the biome data before the palette
                    byteBuf.readerIndex(biomeDataIndex);

                    int blocksPerWord = 32 / bitsPerBlock;
                    int wordsPerChunk = (int) Math.ceil(4096d / blocksPerWord);

                    int pos = 0;
                    for (int i = 0; i < wordsPerChunk; i++) {
                        int word = byteBuf.readIntLE();  // stores multiple biomes in 1 int
                        for (int block = 0; block < blocksPerWord; block++) {
                            if (pos >= 4096) {
                                break;
                            }

                            // Break apart the word into coordinates for each block's biome in the subchunk
                            int paletteIndex = (word >> (pos % blocksPerWord) * bitsPerBlock) & ((1 << bitsPerBlock) - 1);
                            subChunkBiomeMap.setBiomeAt(pos >> 8, pos & 15, (pos >> 4) & 15, palette.getEntry(paletteIndex));

                            pos++;
                        }
                    }
                }

                byteBuf.readerIndex(endOfPaletteIndex);

                // Add the biome subchunk to our biome map.
                lastBiomeSubChunk = subChunkBiomeMap;
                chunkBiomeMapSubChunks[subChunkIndex++] = lastBiomeSubChunk;

            }
            biomeMap.setSubChunks(chunkBiomeMapSubChunks);
            return new LevelDBChunkData(heightMap, biomeMap);
        } finally {
            byteBuf.release();
        }
    }

}
