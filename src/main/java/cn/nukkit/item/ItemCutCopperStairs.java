package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCutCopperStairs extends Item {

    public ItemCutCopperStairs() {
        this(0, 1);
    }

    public ItemCutCopperStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemCutCopperStairs(Integer meta, int count) {
        super(ItemID.CUT_COPPER_STAIRS, meta, count, "Cut Copper Stairs");
        this.block = Block.get(BlockID.CUT_COPPER_STAIRS, meta);
    }
}