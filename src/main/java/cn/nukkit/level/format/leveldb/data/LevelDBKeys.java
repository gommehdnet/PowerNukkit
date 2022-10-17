package cn.nukkit.level.format.leveldb.data;

public enum LevelDBKeys {
    DATA_3D(0x2B),
    CHUNK_VERSION(0x2C),
    SUB_CHUNK_PREFIX(0x2F, true),
    BLOCK_ENTITY(0x31),
    ENTITY(0x32),
    PENDING_TICK(0x33),
    BIOME_STATE(0x35),
    FINALIZED_STATE(0x36),
    HARD_CODED_SPAWN_AREAS(0x39),
    RANDOM_TICKS(0x3A);

    private final byte key;
    private final boolean hasSubKey;

    LevelDBKeys(int key) {
        this((byte) key);
    }
    LevelDBKeys(byte key) {
        this(key, false);
    }

    LevelDBKeys(int key, boolean hasSubKey) {
        this((byte) key, hasSubKey);
    }
    LevelDBKeys(byte key, boolean hasSubKey) {
        this.key = key;
        this.hasSubKey = hasSubKey;
    }

    public byte[] getKey(int x, int z) {
        return new byte[]{
                (byte) (x & 0xff), (byte) ((x >> 8) & 0xff), (byte) ((x >> 16) & 0xff), (byte) ((x >> 24) & 0xff),
                (byte) (z & 0xff), (byte) ((z >> 8) & 0xff), (byte) ((z >> 16) & 0xff), (byte) ((z >> 24) & 0xff),
                this.key
        };
    }

    public byte[] getSubKey(int x, int z, byte subKey) {
        if (!hasSubKey) {
            throw new UnsupportedOperationException("This key does not have a sub key");
        }
        return new byte[]{
                (byte) (x & 0xff), (byte) ((x >> 8) & 0xff), (byte) ((x >> 16) & 0xff), (byte) ((x >> 24) & 0xff),
                (byte) (z & 0xff), (byte) ((z >> 8) & 0xff), (byte) ((z >> 16) & 0xff), (byte) ((z >> 24) & 0xff),
                this.key,
                subKey
        };
    }

    public byte[] getKeyForDimension(int x, int z, int dimension) {
        return new byte[]{
                (byte) (x & 0xff), (byte) ((x >> 8) & 0xff), (byte) ((x >> 16) & 0xff), (byte) ((x >> 24) & 0xff),
                (byte) (z & 0xff), (byte) ((z >> 8) & 0xff), (byte) ((z >> 16) & 0xff), (byte) ((z >> 24) & 0xff),
                (byte) (dimension & 0xff), (byte) ((dimension >> 8) & 0xff), (byte) ((dimension >> 16) & 0xff), (byte) ((dimension >> 24) & 0xff),
                this.key
        };
    }

    public byte[] getSubKeyForDimension(int x, int z, int dimension, byte subKey) {
        if (!hasSubKey) {
            throw new UnsupportedOperationException("This key does not have a sub key");
        }
        return new byte[]{
                (byte) (x & 0xff), (byte) ((x >> 8) & 0xff), (byte) ((x >> 16) & 0xff), (byte) ((x >> 24) & 0xff),
                (byte) (z & 0xff), (byte) ((z >> 8) & 0xff), (byte) ((z >> 16) & 0xff), (byte) ((z >> 24) & 0xff),
                (byte) (dimension & 0xff), (byte) ((dimension >> 8) & 0xff), (byte) ((dimension >> 16) & 0xff), (byte) ((dimension >> 24) & 0xff),
                this.key,
                subKey
        };
    }
}
