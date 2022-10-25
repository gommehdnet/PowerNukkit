package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedSlab extends Item {

    public ItemWarpedSlab() {
        this(0, 1);
    }

    public ItemWarpedSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedSlab(Integer meta, int count) {
        super(ItemID.WARPED_SLAB, meta, count, "Warped Slab");
        this.block = Block.get(BlockID.WARPED_SLAB, meta);
    }
}