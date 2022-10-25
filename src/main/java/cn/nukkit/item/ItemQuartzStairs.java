package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemQuartzStairs extends Item {

    public ItemQuartzStairs() {
        this(0, 1);
    }

    public ItemQuartzStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemQuartzStairs(Integer meta, int count) {
        super(ItemID.QUARTZ_STAIRS, meta, count, "Quartz Stairs");
        this.block = Block.get(BlockID.QUARTZ_STAIRS, meta);
    }
}