package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedOxidizedCutCopper extends Item {

    public ItemWaxedOxidizedCutCopper() {
        this(0, 1);
    }

    public ItemWaxedOxidizedCutCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedOxidizedCutCopper(Integer meta, int count) {
        super(ItemID.WAXED_OXIDIZED_CUT_COPPER, meta, count, "Waxed Oxidized Cut Copper");
        this.block = Block.get(BlockID.WAXED_OXIDIZED_CUT_COPPER, meta);
    }
}