package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDarkOakFenceGate extends Item {

    public ItemDarkOakFenceGate() {
        this(0, 1);
    }

    public ItemDarkOakFenceGate(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkOakFenceGate(Integer meta, int count) {
        super(ItemID.DARK_OAK_FENCE_GATE, meta, count, "Dark Oak Fence Gate");
        this.block = Block.get(BlockID.DARK_OAK_FENCE_GATE, meta);
    }
}