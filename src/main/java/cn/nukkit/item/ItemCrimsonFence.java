package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonFence extends Item {

    public ItemCrimsonFence() {
        this(0, 1);
    }

    public ItemCrimsonFence(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonFence(Integer meta, int count) {
        super(ItemID.CRIMSON_FENCE, meta, count, "Crimson Fence");
        this.block = Block.get(BlockID.CRIMSON_FENCE, meta);
    }
}