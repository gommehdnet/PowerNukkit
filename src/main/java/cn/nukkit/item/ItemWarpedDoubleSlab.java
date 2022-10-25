package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedDoubleSlab extends Item {

    public ItemWarpedDoubleSlab() {
        this(0, 1);
    }

    public ItemWarpedDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedDoubleSlab(Integer meta, int count) {
        super(ItemID.WARPED_DOUBLE_SLAB, meta, count, "Warped Double Slab");
        this.block = Block.get(BlockID.WARPED_DOUBLE_SLAB, meta);
    }
}