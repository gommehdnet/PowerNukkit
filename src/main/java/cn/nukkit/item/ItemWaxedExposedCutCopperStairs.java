package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedExposedCutCopperStairs extends Item {

    public ItemWaxedExposedCutCopperStairs() {
        this(0, 1);
    }

    public ItemWaxedExposedCutCopperStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedExposedCutCopperStairs(Integer meta, int count) {
        super(ItemID.WAXED_EXPOSED_CUT_COPPER_STAIRS, meta, count, "Waxed Exposed Cut Copper Stairs");
        this.block = Block.get(BlockID.WAXED_EXPOSED_CUT_COPPER_STAIRS, meta);
    }
}