package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedWeatheredCutCopperSlab extends Item {

    public ItemWaxedWeatheredCutCopperSlab() {
        this(0, 1);
    }

    public ItemWaxedWeatheredCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedWeatheredCutCopperSlab(Integer meta, int count) {
        super(ItemID.WAXED_WEATHERED_CUT_COPPER_SLAB, meta, count, "Waxed Weathered Cut Copper Slab");
        this.block = Block.get(BlockID.WAXED_WEATHERED_CUT_COPPER_SLAB, meta);
    }
}