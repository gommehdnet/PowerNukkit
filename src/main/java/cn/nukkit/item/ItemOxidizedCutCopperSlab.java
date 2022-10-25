package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOxidizedCutCopperSlab extends Item {

    public ItemOxidizedCutCopperSlab() {
        this(0, 1);
    }

    public ItemOxidizedCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemOxidizedCutCopperSlab(Integer meta, int count) {
        super(ItemID.OXIDIZED_CUT_COPPER_SLAB, meta, count, "Oxidized Cut Copper Slab");
        this.block = Block.get(BlockID.OXIDIZED_CUT_COPPER_SLAB, meta);
    }
}