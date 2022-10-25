package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFence extends Item {

    public ItemFence() {
        this(0, 1);
    }

    public ItemFence(Integer meta) {
        this(meta, 1);
    }

    public ItemFence(Integer meta, int count) {
        super(ItemID.FENCE, meta, count, "Fence");
        this.block = Block.get(BlockID.FENCE, meta);
    }
}