package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFenceGate extends Item {

    public ItemFenceGate() {
        this(0, 1);
    }

    public ItemFenceGate(Integer meta) {
        this(meta, 1);
    }

    public ItemFenceGate(Integer meta, int count) {
        super(ItemID.FENCE_GATE, meta, count, "Fence Gate");
        this.block = Block.get(BlockID.FENCE_GATE, meta);
    }
}