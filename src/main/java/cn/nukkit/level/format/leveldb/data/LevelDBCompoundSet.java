package cn.nukkit.level.format.leveldb.data;

import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Set;

public class LevelDBCompoundSet {

    public static Set<CompoundTag> read(byte[] data) throws IOException {
        HashSet<CompoundTag> set = new HashSet<>();
        if (data == null) {
            return set;
        }

        try (InputStream blockEntityDataStream = new ByteArrayInputStream(data)) {
            while (blockEntityDataStream.available() > 0) {
                 CompoundTag compoundTag = (CompoundTag) NBTIO.readTag(blockEntityDataStream, ByteOrder.LITTLE_ENDIAN, false);
                set.add(compoundTag);
            }
        }
        return set;
    }

    public static byte[] write(Set<CompoundTag> set) throws IOException {
        return NBTIO.write(set, ByteOrder.LITTLE_ENDIAN, false);
    }


}
