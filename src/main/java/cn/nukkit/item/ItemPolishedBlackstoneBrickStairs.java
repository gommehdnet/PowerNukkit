package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneBrickStairs extends Item {

    public ItemPolishedBlackstoneBrickStairs() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneBrickStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneBrickStairs(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_BRICK_STAIRS, meta, count, "Polished Blackstone Brick Stairs");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_BRICK_STAIRS, meta);
    }
}