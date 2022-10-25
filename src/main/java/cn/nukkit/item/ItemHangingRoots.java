package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHangingRoots extends Item {

    public ItemHangingRoots() {
        this(0, 1);
    }

    public ItemHangingRoots(Integer meta) {
        this(meta, 1);
    }

    public ItemHangingRoots(Integer meta, int count) {
        super(ItemID.HANGING_ROOTS, meta, count, "Hanging Roots");
        this.block = Block.get(BlockID.HANGING_ROOTS, meta);
    }
}