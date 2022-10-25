package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveFenceGate extends Item {

    public ItemMangroveFenceGate() {
        this(0, 1);
    }

    public ItemMangroveFenceGate(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveFenceGate(Integer meta, int count) {
        super(ItemID.MANGROVE_FENCE_GATE, meta, count, "Mangrove Fence Gate");
        this.block = Block.get(BlockID.MANGROVE_FENCE_GATE, meta);
    }
}