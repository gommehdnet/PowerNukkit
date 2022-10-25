package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedExposedDoubleCutCopperSlab extends Item {

    public ItemWaxedExposedDoubleCutCopperSlab() {
        this(0, 1);
    }

    public ItemWaxedExposedDoubleCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedExposedDoubleCutCopperSlab(Integer meta, int count) {
        super(ItemID.WAXED_EXPOSED_DOUBLE_CUT_COPPER_SLAB, meta, count, "Waxed Exposed Double Cut Copper Slab");
        this.block = Block.get(BlockID.WAXED_EXPOSED_DOUBLE_CUT_COPPER_SLAB, meta);
    }
}