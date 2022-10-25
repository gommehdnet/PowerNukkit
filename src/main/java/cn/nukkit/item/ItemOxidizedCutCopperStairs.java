package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOxidizedCutCopperStairs extends Item {

    public ItemOxidizedCutCopperStairs() {
        this(0, 1);
    }

    public ItemOxidizedCutCopperStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemOxidizedCutCopperStairs(Integer meta, int count) {
        super(ItemID.OXIDIZED_CUT_COPPER_STAIRS, meta, count, "Oxidized Cut Copper Stairs");
        this.block = Block.get(BlockID.OXIDIZED_CUT_COPPER_STAIRS, meta);
    }
}