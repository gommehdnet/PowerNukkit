package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneBrickWall extends Item {

    public ItemPolishedBlackstoneBrickWall() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneBrickWall(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneBrickWall(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_BRICK_WALL, meta, count, "Polished Blackstone Brick Wall");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_BRICK_WALL, meta);
    }
}