package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMudBrickStairs extends Item {

    public ItemMudBrickStairs() {
        this(0, 1);
    }

    public ItemMudBrickStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemMudBrickStairs(Integer meta, int count) {
        super(ItemID.MUD_BRICK_STAIRS, meta, count, "Mud Brick Stairs");
        this.block = Block.get(BlockID.MUD_BRICK_STAIRS, meta);
    }
}