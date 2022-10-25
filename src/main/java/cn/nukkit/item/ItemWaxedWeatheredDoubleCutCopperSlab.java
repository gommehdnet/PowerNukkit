package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedWeatheredDoubleCutCopperSlab extends Item {

    public ItemWaxedWeatheredDoubleCutCopperSlab() {
        this(0, 1);
    }

    public ItemWaxedWeatheredDoubleCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedWeatheredDoubleCutCopperSlab(Integer meta, int count) {
        super(ItemID.WAXED_WEATHERED_DOUBLE_CUT_COPPER_SLAB, meta, count, "Waxed Weathered Double Cut Copper Slab");
        this.block = Block.get(BlockID.WAXED_WEATHERED_DOUBLE_CUT_COPPER_SLAB, meta);
    }
}