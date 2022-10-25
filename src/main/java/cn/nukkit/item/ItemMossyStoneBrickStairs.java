package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMossyStoneBrickStairs extends Item {

    public ItemMossyStoneBrickStairs() {
        this(0, 1);
    }

    public ItemMossyStoneBrickStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemMossyStoneBrickStairs(Integer meta, int count) {
        super(ItemID.MOSSY_STONE_BRICK_STAIRS, meta, count, "Mossy Stone Brick Stairs");
        this.block = Block.get(BlockID.MOSSY_STONE_BRICK_STAIRS, meta);
    }
}