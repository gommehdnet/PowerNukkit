package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNetherBrickFence extends Item {

    public ItemNetherBrickFence() {
        this(0, 1);
    }

    public ItemNetherBrickFence(Integer meta) {
        this(meta, 1);
    }

    public ItemNetherBrickFence(Integer meta, int count) {
        super(ItemID.NETHER_BRICK_FENCE, meta, count, "Nether Brick Fence");
        this.block = Block.get(BlockID.NETHER_BRICK_FENCE, meta);
    }
}