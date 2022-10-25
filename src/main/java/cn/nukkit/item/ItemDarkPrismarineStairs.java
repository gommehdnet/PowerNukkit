package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDarkPrismarineStairs extends Item {

    public ItemDarkPrismarineStairs() {
        this(0, 1);
    }

    public ItemDarkPrismarineStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkPrismarineStairs(Integer meta, int count) {
        super(ItemID.DARK_PRISMARINE_STAIRS, meta, count, "Dark Prismarine Stairs");
        this.block = Block.get(BlockID.DARK_PRISMARINE_STAIRS, meta);
    }
}