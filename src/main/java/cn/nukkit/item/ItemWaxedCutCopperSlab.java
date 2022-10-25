package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedCutCopperSlab extends Item {

    public ItemWaxedCutCopperSlab() {
        this(0, 1);
    }

    public ItemWaxedCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedCutCopperSlab(Integer meta, int count) {
        super(ItemID.WAXED_CUT_COPPER_SLAB, meta, count, "Waxed Cut Copper Slab");
        this.block = Block.get(BlockID.WAXED_CUT_COPPER_SLAB, meta);
    }
}