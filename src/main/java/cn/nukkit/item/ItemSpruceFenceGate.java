package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpruceFenceGate extends Item {

    public ItemSpruceFenceGate() {
        this(0, 1);
    }

    public ItemSpruceFenceGate(Integer meta) {
        this(meta, 1);
    }

    public ItemSpruceFenceGate(Integer meta, int count) {
        super(ItemID.SPRUCE_FENCE_GATE, meta, count, "Spruce Fence Gate");
        this.block = Block.get(BlockID.SPRUCE_FENCE_GATE, meta);
    }
}