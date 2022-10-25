package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedFence extends Item {

    public ItemWarpedFence() {
        this(0, 1);
    }

    public ItemWarpedFence(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedFence(Integer meta, int count) {
        super(ItemID.WARPED_FENCE, meta, count, "Warped Fence");
        this.block = Block.get(BlockID.WARPED_FENCE, meta);
    }
}