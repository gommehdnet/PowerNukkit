package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCutCopper extends Item {

    public ItemCutCopper() {
        this(0, 1);
    }

    public ItemCutCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemCutCopper(Integer meta, int count) {
        super(ItemID.CUT_COPPER, meta, count, "Cut Copper");
        this.block = Block.get(BlockID.CUT_COPPER, meta);
    }
}