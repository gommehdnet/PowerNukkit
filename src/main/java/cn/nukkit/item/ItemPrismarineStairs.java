package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPrismarineStairs extends Item {

    public ItemPrismarineStairs() {
        this(0, 1);
    }

    public ItemPrismarineStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemPrismarineStairs(Integer meta, int count) {
        super(ItemID.PRISMARINE_STAIRS, meta, count, "Prismarine Stairs");
        this.block = Block.get(BlockID.PRISMARINE_STAIRS, meta);
    }
}