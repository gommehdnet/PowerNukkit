package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedWeatheredCutCopperStairs extends Item {

    public ItemWaxedWeatheredCutCopperStairs() {
        this(0, 1);
    }

    public ItemWaxedWeatheredCutCopperStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedWeatheredCutCopperStairs(Integer meta, int count) {
        super(ItemID.WAXED_WEATHERED_CUT_COPPER_STAIRS, meta, count, "Waxed Weathered Cut Copper Stairs");
        this.block = Block.get(BlockID.WAXED_WEATHERED_CUT_COPPER_STAIRS, meta);
    }
}