package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedOxidizedCutCopperSlab extends Item {

    public ItemWaxedOxidizedCutCopperSlab() {
        this(0, 1);
    }

    public ItemWaxedOxidizedCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedOxidizedCutCopperSlab(Integer meta, int count) {
        super(ItemID.WAXED_OXIDIZED_CUT_COPPER_SLAB, meta, count, "Waxed Oxidized Cut Copper Slab");
        this.block = Block.get(BlockID.WAXED_OXIDIZED_CUT_COPPER_SLAB, meta);
    }
}