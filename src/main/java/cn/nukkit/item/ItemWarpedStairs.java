package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedStairs extends Item {

    public ItemWarpedStairs() {
        this(0, 1);
    }

    public ItemWarpedStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedStairs(Integer meta, int count) {
        super(ItemID.WARPED_STAIRS, meta, count, "Warped Stairs");
        this.block = Block.get(BlockID.WARPED_STAIRS, meta);
    }
}