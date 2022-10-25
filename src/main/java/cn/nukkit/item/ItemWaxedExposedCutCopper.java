package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedExposedCutCopper extends Item {

    public ItemWaxedExposedCutCopper() {
        this(0, 1);
    }

    public ItemWaxedExposedCutCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedExposedCutCopper(Integer meta, int count) {
        super(ItemID.WAXED_EXPOSED_CUT_COPPER, meta, count, "Waxed Exposed Cut Copper");
        this.block = Block.get(BlockID.WAXED_EXPOSED_CUT_COPPER, meta);
    }
}