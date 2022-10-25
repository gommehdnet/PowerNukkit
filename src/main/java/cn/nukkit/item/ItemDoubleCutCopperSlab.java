package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDoubleCutCopperSlab extends Item {

    public ItemDoubleCutCopperSlab() {
        this(0, 1);
    }

    public ItemDoubleCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemDoubleCutCopperSlab(Integer meta, int count) {
        super(ItemID.DOUBLE_CUT_COPPER_SLAB, meta, count, "Double Cut Copper Slab");
        this.block = Block.get(BlockID.DOUBLE_CUT_COPPER_SLAB, meta);
    }
}