package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJungleFenceGate extends Item {

    public ItemJungleFenceGate() {
        this(0, 1);
    }

    public ItemJungleFenceGate(Integer meta) {
        this(meta, 1);
    }

    public ItemJungleFenceGate(Integer meta, int count) {
        super(ItemID.JUNGLE_FENCE_GATE, meta, count, "Jungle Fence Gate");
        this.block = Block.get(BlockID.JUNGLE_FENCE_GATE, meta);
    }
}