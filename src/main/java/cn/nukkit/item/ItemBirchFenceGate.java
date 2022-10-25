package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBirchFenceGate extends Item {

    public ItemBirchFenceGate() {
        this(0, 1);
    }

    public ItemBirchFenceGate(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchFenceGate(Integer meta, int count) {
        super(ItemID.BIRCH_FENCE_GATE, meta, count, "Birch Fence Gate");
        this.block = Block.get(BlockID.BIRCH_FENCE_GATE, meta);
    }
}