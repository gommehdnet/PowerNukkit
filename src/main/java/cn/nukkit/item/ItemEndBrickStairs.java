package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndBrickStairs extends Item {

    public ItemEndBrickStairs() {
        this(0, 1);
    }

    public ItemEndBrickStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemEndBrickStairs(Integer meta, int count) {
        super(ItemID.END_BRICK_STAIRS, meta, count, "End Brick Stairs");
        this.block = Block.get(BlockID.END_BRICK_STAIRS, meta);
    }
}