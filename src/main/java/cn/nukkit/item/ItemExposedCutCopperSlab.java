package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemExposedCutCopperSlab extends Item {

    public ItemExposedCutCopperSlab() {
        this(0, 1);
    }

    public ItemExposedCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemExposedCutCopperSlab(Integer meta, int count) {
        super(ItemID.EXPOSED_CUT_COPPER_SLAB, meta, count, "Exposed Cut Copper Slab");
        this.block = Block.get(BlockID.EXPOSED_CUT_COPPER_SLAB, meta);
    }
}