package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

public class ItemSpruceDoor extends Item {
    public ItemSpruceDoor() {
        this(0, 1);
    }

    public ItemSpruceDoor(Integer meta) {
        this(meta, 1);
    }

    public ItemSpruceDoor(Integer meta, int count) {
        super(ItemID.SPRUCE_DOOR, 0, count, "Spruce Door");
        this.block = Block.get(BlockID.SPRUCE_DOOR);
    }

}
