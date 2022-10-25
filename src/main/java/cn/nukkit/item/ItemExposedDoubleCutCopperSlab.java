package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemExposedDoubleCutCopperSlab extends Item {

    public ItemExposedDoubleCutCopperSlab() {
        this(0, 1);
    }

    public ItemExposedDoubleCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemExposedDoubleCutCopperSlab(Integer meta, int count) {
        super(ItemID.EXPOSED_DOUBLE_CUT_COPPER_SLAB, meta, count, "Exposed Double Cut Copper Slab");
        this.block = Block.get(BlockID.EXPOSED_DOUBLE_CUT_COPPER_SLAB, meta);
    }
}