package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedRoots extends Item {

    public ItemWarpedRoots() {
        this(0, 1);
    }

    public ItemWarpedRoots(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedRoots(Integer meta, int count) {
        super(ItemID.WARPED_ROOTS, meta, count, "Warped Roots");
        this.block = Block.get(BlockID.WARPED_ROOTS, meta);
    }
}