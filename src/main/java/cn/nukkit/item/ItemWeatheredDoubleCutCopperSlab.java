package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWeatheredDoubleCutCopperSlab extends Item {

    public ItemWeatheredDoubleCutCopperSlab() {
        this(0, 1);
    }

    public ItemWeatheredDoubleCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWeatheredDoubleCutCopperSlab(Integer meta, int count) {
        super(ItemID.WEATHERED_DOUBLE_CUT_COPPER_SLAB, meta, count, "Weathered Double Cut Copper Slab");
        this.block = Block.get(BlockID.WEATHERED_DOUBLE_CUT_COPPER_SLAB, meta);
    }
}