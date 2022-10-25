package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedCutCopperStairs extends Item {

    public ItemWaxedCutCopperStairs() {
        this(0, 1);
    }

    public ItemWaxedCutCopperStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedCutCopperStairs(Integer meta, int count) {
        super(ItemID.WAXED_CUT_COPPER_STAIRS, meta, count, "Waxed Cut Copper Stairs");
        this.block = Block.get(BlockID.WAXED_CUT_COPPER_STAIRS, meta);
    }
}