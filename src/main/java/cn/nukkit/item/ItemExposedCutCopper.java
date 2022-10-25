package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemExposedCutCopper extends Item {

    public ItemExposedCutCopper() {
        this(0, 1);
    }

    public ItemExposedCutCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemExposedCutCopper(Integer meta, int count) {
        super(ItemID.EXPOSED_CUT_COPPER, meta, count, "Exposed Cut Copper");
        this.block = Block.get(BlockID.EXPOSED_CUT_COPPER, meta);
    }
}