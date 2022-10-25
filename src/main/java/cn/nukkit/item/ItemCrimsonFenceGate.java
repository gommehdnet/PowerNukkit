package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonFenceGate extends Item {

    public ItemCrimsonFenceGate() {
        this(0, 1);
    }

    public ItemCrimsonFenceGate(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonFenceGate(Integer meta, int count) {
        super(ItemID.CRIMSON_FENCE_GATE, meta, count, "Crimson Fence Gate");
        this.block = Block.get(BlockID.CRIMSON_FENCE_GATE, meta);
    }
}