package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOxidizedDoubleCutCopperSlab extends Item {

    public ItemOxidizedDoubleCutCopperSlab() {
        this(0, 1);
    }

    public ItemOxidizedDoubleCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemOxidizedDoubleCutCopperSlab(Integer meta, int count) {
        super(ItemID.OXIDIZED_DOUBLE_CUT_COPPER_SLAB, meta, count, "Oxidized Double Cut Copper Slab");
        this.block = Block.get(BlockID.OXIDIZED_DOUBLE_CUT_COPPER_SLAB, meta);
    }
}