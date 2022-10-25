package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

public class ItemJungleDoor extends Item {
    public ItemJungleDoor() {
        this(0, 1);
    }

    public ItemJungleDoor(Integer meta) {
        this(meta, 1);
    }

    public ItemJungleDoor(Integer meta, int count) {
        super(ItemID.JUNGLE_DOOR, 0, count, "Jungle Door");
        this.block = Block.get(BlockID.JUNGLE_DOOR);
    }

}
