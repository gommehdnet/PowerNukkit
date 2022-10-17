package cn.nukkit.level.format.leveldb.data;

import cn.nukkit.level.format.leveldb.palette.IntPalette;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class LevelDBChunkBiomeMap {

    @Getter
    private SubChunk[] subChunks = new SubChunk[25];

    public void setSubChunks(SubChunk[] subChunks) {
        this.subChunks = subChunks;
    }


    public SubChunk getTopSubChunk() {
        return subChunks[0];
    }


    public static class SubChunk {
        @Getter
        private IntPalette palette;
        private byte[] biomes = new byte[4096];


        public SubChunk(IntPalette palette) {
            this.palette = palette;
        }

        public int getBiomeAt(int x, int y, int z) {
            return this.biomes[getChunkPosIndex(x, y, z)];
        }

        public void setBiomeAt(int x, int y, int z, int biome) {
            this.palette.addEntry(biome);
            this.biomes[getChunkPosIndex(x, y, z)] = (byte) biome;
        }

        private static int getChunkPosIndex(int x, int y, int z) {
            return x << 8 | x << 4 | y;
        }

        @Override
        public SubChunk clone() {
            try {
                SubChunk subChunkBiomeMap = (SubChunk) super.clone();
                subChunkBiomeMap.palette = this.palette.clone();

                byte[] copiedBiomes = new byte[4096];
                System.arraycopy(this.biomes, 0, copiedBiomes, 0, copiedBiomes.length);
                subChunkBiomeMap.biomes = copiedBiomes;

                return subChunkBiomeMap;
            } catch (CloneNotSupportedException exception) {
                throw new AssertionError("Clone threw exception");
            }
        }
    }

}
