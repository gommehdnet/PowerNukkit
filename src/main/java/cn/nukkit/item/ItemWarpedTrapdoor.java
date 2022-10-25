package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedTrapdoor extends Item {

    public ItemWarpedTrapdoor() {
        this(0, 1);
    }

    public ItemWarpedTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedTrapdoor(Integer meta, int count) {
        super(ItemID.WARPED_TRAPDOOR, meta, count, "Warped Trapdoor");
        this.block = Block.get(BlockID.WARPED_TRAPDOOR, meta);
    }
}