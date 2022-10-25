package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedCutCopper extends Item {

    public ItemWaxedCutCopper() {
        this(0, 1);
    }

    public ItemWaxedCutCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedCutCopper(Integer meta, int count) {
        super(ItemID.WAXED_CUT_COPPER, meta, count, "Waxed Cut Copper");
        this.block = Block.get(BlockID.WAXED_CUT_COPPER, meta);
    }
}