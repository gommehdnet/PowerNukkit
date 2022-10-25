package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemExposedCutCopperStairs extends Item {

    public ItemExposedCutCopperStairs() {
        this(0, 1);
    }

    public ItemExposedCutCopperStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemExposedCutCopperStairs(Integer meta, int count) {
        super(ItemID.EXPOSED_CUT_COPPER_STAIRS, meta, count, "Exposed Cut Copper Stairs");
        this.block = Block.get(BlockID.EXPOSED_CUT_COPPER_STAIRS, meta);
    }
}