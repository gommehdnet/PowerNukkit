package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSmoothQuartzStairs extends Item {

    public ItemSmoothQuartzStairs() {
        this(0, 1);
    }

    public ItemSmoothQuartzStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemSmoothQuartzStairs(Integer meta, int count) {
        super(ItemID.SMOOTH_QUARTZ_STAIRS, meta, count, "Smooth Quartz Stairs");
        this.block = Block.get(BlockID.SMOOTH_QUARTZ_STAIRS, meta);
    }
}