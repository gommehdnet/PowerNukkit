package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWeatheredCutCopperStairs extends Item {

    public ItemWeatheredCutCopperStairs() {
        this(0, 1);
    }

    public ItemWeatheredCutCopperStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemWeatheredCutCopperStairs(Integer meta, int count) {
        super(ItemID.WEATHERED_CUT_COPPER_STAIRS, meta, count, "Weathered Cut Copper Stairs");
        this.block = Block.get(BlockID.WEATHERED_CUT_COPPER_STAIRS, meta);
    }
}