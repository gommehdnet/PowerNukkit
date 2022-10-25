package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateBrickStairs extends Item {

    public ItemDeepslateBrickStairs() {
        this(0, 1);
    }

    public ItemDeepslateBrickStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateBrickStairs(Integer meta, int count) {
        super(ItemID.DEEPSLATE_BRICK_STAIRS, meta, count, "Deepslate Brick Stairs");
        this.block = Block.get(BlockID.DEEPSLATE_BRICK_STAIRS, meta);
    }
}