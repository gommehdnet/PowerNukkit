package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSmoothSandstoneStairs extends Item {

    public ItemSmoothSandstoneStairs() {
        this(0, 1);
    }

    public ItemSmoothSandstoneStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemSmoothSandstoneStairs(Integer meta, int count) {
        super(ItemID.SMOOTH_SANDSTONE_STAIRS, meta, count, "Smooth Sandstone Stairs");
        this.block = Block.get(BlockID.SMOOTH_SANDSTONE_STAIRS, meta);
    }
}