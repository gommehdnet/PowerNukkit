package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedOxidizedDoubleCutCopperSlab extends Item {

    public ItemWaxedOxidizedDoubleCutCopperSlab() {
        this(0, 1);
    }

    public ItemWaxedOxidizedDoubleCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedOxidizedDoubleCutCopperSlab(Integer meta, int count) {
        super(ItemID.WAXED_OXIDIZED_DOUBLE_CUT_COPPER_SLAB, meta, count, "Waxed Oxidized Double Cut Copper Slab");
        this.block = Block.get(BlockID.WAXED_OXIDIZED_DOUBLE_CUT_COPPER_SLAB, meta);
    }
}