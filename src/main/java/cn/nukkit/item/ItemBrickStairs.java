package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBrickStairs extends Item {

    public ItemBrickStairs() {
        this(0, 1);
    }

    public ItemBrickStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemBrickStairs(Integer meta, int count) {
        super(ItemID.BRICK_STAIRS, meta, count, "Brick Stairs");
        this.block = Block.get(BlockID.BRICK_STAIRS, meta);
    }
}