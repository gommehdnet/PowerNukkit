package cn.nukkit.level.format.leveldb;

import cn.nukkit.blockstate.BlockState;
import cn.nukkit.nbt.tag.CompoundTag;
import lombok.Getter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class UnknownBlockState extends BlockState {

    @Getter
    private CompoundTag compoundTag;

    public UnknownBlockState(@Nonnull CompoundTag compoundTag, int unknownBlockId) {
        super(unknownBlockId);
        this.compoundTag = compoundTag;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (o instanceof UnknownBlockState) {
            UnknownBlockState unknownBlockState = (UnknownBlockState) o;
            if (super.equals(unknownBlockState) && this.compoundTag.equals(unknownBlockState.compoundTag)) {
                return true;
            }
        }
        return false;
    }
}
