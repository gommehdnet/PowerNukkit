package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNetherBrickStairs extends Item {

    public ItemNetherBrickStairs() {
        this(0, 1);
    }

    public ItemNetherBrickStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemNetherBrickStairs(Integer meta, int count) {
        super(ItemID.NETHER_BRICK_STAIRS, meta, count, "Nether Brick Stairs");
        this.block = Block.get(BlockID.NETHER_BRICK_STAIRS, meta);
    }
}