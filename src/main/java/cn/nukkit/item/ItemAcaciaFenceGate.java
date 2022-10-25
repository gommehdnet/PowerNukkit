package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaFenceGate extends Item {

    public ItemAcaciaFenceGate() {
        this(0, 1);
    }

    public ItemAcaciaFenceGate(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaFenceGate(Integer meta, int count) {
        super(ItemID.ACACIA_FENCE_GATE, meta, count, "Acacia Fence Gate");
        this.block = Block.get(BlockID.ACACIA_FENCE_GATE, meta);
    }
}