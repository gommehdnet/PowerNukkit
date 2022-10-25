package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSmoothRedSandstoneStairs extends Item {

    public ItemSmoothRedSandstoneStairs() {
        this(0, 1);
    }

    public ItemSmoothRedSandstoneStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemSmoothRedSandstoneStairs(Integer meta, int count) {
        super(ItemID.SMOOTH_RED_SANDSTONE_STAIRS, meta, count, "Smooth Red Sandstone Stairs");
        this.block = Block.get(BlockID.SMOOTH_RED_SANDSTONE_STAIRS, meta);
    }
}