package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedPlanks extends Item {

    public ItemWarpedPlanks() {
        this(0, 1);
    }

    public ItemWarpedPlanks(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedPlanks(Integer meta, int count) {
        super(ItemID.WARPED_PLANKS, meta, count, "Warped Planks");
        this.block = Block.get(BlockID.WARPED_PLANKS, meta);
    }
}