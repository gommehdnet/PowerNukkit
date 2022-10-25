package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedDoubleCutCopperSlab extends Item {

    public ItemWaxedDoubleCutCopperSlab() {
        this(0, 1);
    }

    public ItemWaxedDoubleCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedDoubleCutCopperSlab(Integer meta, int count) {
        super(ItemID.WAXED_DOUBLE_CUT_COPPER_SLAB, meta, count, "Waxed Double Cut Copper Slab");
        this.block = Block.get(BlockID.WAXED_DOUBLE_CUT_COPPER_SLAB, meta);
    }
}