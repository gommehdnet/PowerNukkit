package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

public class ItemBirchDoor extends Item {
    public ItemBirchDoor() {
        this(0, 1);
    }

    public ItemBirchDoor(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchDoor(Integer meta, int count) {
        super(ItemID.BIRCH_DOOR, 0, count, "Birch Door");
        this.block = Block.get(BlockID.BIRCH_DOOR, meta);
    }

}
