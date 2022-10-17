package cn.nukkit.level.format.leveldb.data;

public class LevelDBChunkHeightMap {
    private final int[] heightMap = new int[256];

    public int getHighestBlockAt(int x, int z) {
        return this.heightMap[getChunkIndex(x & 0xF, z & 0xF)];
    }

    public void setHighestBlockAt(int x, int z, int newHeight) {
        this.heightMap[getChunkIndex(x & 0xF, z & 0xF)] = newHeight;
    }

    public int[] array() {
        return this.heightMap;
    }

    private static int getChunkIndex(int x, int z) {
        return z << 4 | x;
    }
}
