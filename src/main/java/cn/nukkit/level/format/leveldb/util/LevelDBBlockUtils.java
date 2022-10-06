package cn.nukkit.level.format.leveldb.util;

import cn.nukkit.blockproperty.ArrayBlockProperty;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.blockstate.BlockStateRegistry;
import cn.nukkit.nbt.tag.*;

import java.io.Serializable;
import java.util.Map;

public class LevelDBBlockUtils {
    public static CompoundTag blockState2Nbt(BlockState blockState) {
        CompoundTag tag = new CompoundTag()
                .putString("name", blockState.getPersistenceName())
                .putInt("version", blockState.getVersion());
        BlockProperties properties = blockState.getProperties();
        CompoundTag stateTag = BlockStateRegistry.getBlockStateNbtTemplate(blockState.getBlockId());
        if (stateTag == null) {
            stateTag = new CompoundTag();
        } else {
            if (blockState.getVersion() == -1) {
                tag.putInt("version", stateTag.getInt("version"));
            }
            stateTag = stateTag.getCompound("states");
        }
        for (String each : properties.getNames()) {
            Tag entry = stateTag.get(each);
            if (entry == null) {
                continue;
            }
            if (entry instanceof IntTag) {
                stateTag.putInt(each, blockState.getIntValue(each));
            } else if (entry instanceof ByteTag) {
                Serializable value = blockState.getPropertyValue(each);
                if (value instanceof Boolean) {

                    stateTag.putByte(each, ((Boolean) value) ? 1 : 0);
                } else {
                    stateTag.putByte(each, blockState.getIntValue(each));
                }
            } else if (entry instanceof StringTag) {
                stateTag.putString(each, blockState.getPersistenceValue(each));
            }
        }
        tag.putCompound("states", stateTag);
        return tag;
    }

    public static BlockState nbt2BlockState(CompoundTag nbt) {
        BlockState blockState = BlockState.of(nbt.getString("name"), true);
        blockState.setVersion(nbt.getInt("version"));
        CompoundTag stateTag = nbt.getCompound("states");

        for (Map.Entry<String, Tag> each : stateTag.getTags().entrySet()) {
            Tag value = each.getValue();
            if (value instanceof IntTag) {
                IntTag intTag = (IntTag) value;
                if (blockState.getProperty(each.getKey()) instanceof ArrayBlockProperty<?>) {
                    blockState = blockState.withProperty(each.getKey(), ((ArrayBlockProperty<?>) blockState.getProperty(each.getKey())).getUniverse()[intTag.data]);
                } else {
                    blockState = blockState.withProperty(each.getKey(), intTag.data);
                }
            } else if (value instanceof ByteTag) {
                ByteTag byteTag = (ByteTag) value;
                if (blockState.getProperty(each.getKey()).getBitSize() == 1) {
                    blockState = blockState.withProperty(each.getKey(), byteTag.data == 1);
                } else {
                    blockState = blockState.withProperty(each.getKey(), byteTag.data);
                }
            } else if (value instanceof StringTag) {
                StringTag stringTag = (StringTag) value;
                blockState = blockState.withProperty(each.getKey(), stringTag.data);
            }
        }
        return blockState;
    }
}
