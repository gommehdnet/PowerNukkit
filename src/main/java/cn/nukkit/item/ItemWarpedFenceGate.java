package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedFenceGate extends Item {

    public ItemWarpedFenceGate() {
        this(0, 1);
    }

    public ItemWarpedFenceGate(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedFenceGate(Integer meta, int count) {
        super(ItemID.WARPED_FENCE_GATE, meta, count, "Warped Fence Gate");
        this.block = Block.get(BlockID.WARPED_FENCE_GATE, meta);
    }
}