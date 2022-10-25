package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPrismarineBricksStairs extends Item {

    public ItemPrismarineBricksStairs() {
        this(0, 1);
    }

    public ItemPrismarineBricksStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemPrismarineBricksStairs(Integer meta, int count) {
        super(ItemID.PRISMARINE_BRICKS_STAIRS, meta, count, "Prismarine Bricks Stairs");
        this.block = Block.get(BlockID.PRISMARINE_BRICKS_STAIRS, meta);
    }
}