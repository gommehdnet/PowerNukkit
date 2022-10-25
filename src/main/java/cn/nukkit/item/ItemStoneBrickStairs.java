package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStoneBrickStairs extends Item {

    public ItemStoneBrickStairs() {
        this(0, 1);
    }

    public ItemStoneBrickStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemStoneBrickStairs(Integer meta, int count) {
        super(ItemID.STONE_BRICK_STAIRS, meta, count, "Stone Brick Stairs");
        this.block = Block.get(BlockID.STONE_BRICK_STAIRS, meta);
    }
}