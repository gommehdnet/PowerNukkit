package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemWoodenDoor extends Item {

    public ItemWoodenDoor() {
        this(0, 1);
    }

    public ItemWoodenDoor(Integer meta) {
        this(meta, 1);
    }

    public ItemWoodenDoor(Integer meta, int count) {
        super(ItemID.WOODEN_DOOR, 0, count, "Oak Door");
        this.block = Block.get(BlockID.WOODEN_DOOR);
    }

}
