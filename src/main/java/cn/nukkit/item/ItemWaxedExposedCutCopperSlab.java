package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedExposedCutCopperSlab extends Item {

    public ItemWaxedExposedCutCopperSlab() {
        this(0, 1);
    }

    public ItemWaxedExposedCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedExposedCutCopperSlab(Integer meta, int count) {
        super(ItemID.WAXED_EXPOSED_CUT_COPPER_SLAB, meta, count, "Waxed Exposed Cut Copper Slab");
        this.block = Block.get(BlockID.WAXED_EXPOSED_CUT_COPPER_SLAB, meta);
    }
}