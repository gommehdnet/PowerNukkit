package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

public class ItemDarkOakDoor extends Item {
    public ItemDarkOakDoor() {
        this(0, 1);
    }

    public ItemDarkOakDoor(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkOakDoor(Integer meta, int count) {
        super(ItemID.DARK_OAK_DOOR, 0, count, "Dark Oak Door");
        this.block = Block.get(BlockID.DARK_OAK_DOOR);
    }

}
