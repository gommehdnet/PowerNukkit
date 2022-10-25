package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedOxidizedCutCopperStairs extends Item {

    public ItemWaxedOxidizedCutCopperStairs() {
        this(0, 1);
    }

    public ItemWaxedOxidizedCutCopperStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedOxidizedCutCopperStairs(Integer meta, int count) {
        super(ItemID.WAXED_OXIDIZED_CUT_COPPER_STAIRS, meta, count, "Waxed Oxidized Cut Copper Stairs");
        this.block = Block.get(BlockID.WAXED_OXIDIZED_CUT_COPPER_STAIRS, meta);
    }
}