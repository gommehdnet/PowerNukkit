package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCutCopperSlab extends Item {

    public ItemCutCopperSlab() {
        this(0, 1);
    }

    public ItemCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemCutCopperSlab(Integer meta, int count) {
        super(ItemID.CUT_COPPER_SLAB, meta, count, "Cut Copper Slab");
        this.block = Block.get(BlockID.CUT_COPPER_SLAB, meta);
    }
}