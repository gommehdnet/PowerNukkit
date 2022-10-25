package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDarkOakStairs extends Item {

    public ItemDarkOakStairs() {
        this(0, 1);
    }

    public ItemDarkOakStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkOakStairs(Integer meta, int count) {
        super(ItemID.DARK_OAK_STAIRS, meta, count, "Dark Oak Stairs");
        this.block = Block.get(BlockID.DARK_OAK_STAIRS, meta);
    }
}