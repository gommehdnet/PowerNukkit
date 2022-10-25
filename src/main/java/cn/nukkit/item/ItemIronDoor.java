package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemIronDoor extends Item {

    public ItemIronDoor() {
        this(0, 1);
    }

    public ItemIronDoor(Integer meta) {
        this(meta, 1);
    }

    public ItemIronDoor(Integer meta, int count) {
        super(ItemID.IRON_DOOR, 0, count, "Iron Door");
        this.block = Block.get(BlockID.IRON_DOOR);
    }

}
