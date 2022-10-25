package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedNetherBrickStairs extends Item {

    public ItemRedNetherBrickStairs() {
        this(0, 1);
    }

    public ItemRedNetherBrickStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemRedNetherBrickStairs(Integer meta, int count) {
        super(ItemID.RED_NETHER_BRICK_STAIRS, meta, count, "Red Nether Brick Stairs");
        this.block = Block.get(BlockID.RED_NETHER_BRICK_STAIRS, meta);
    }
}