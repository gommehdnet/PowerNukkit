package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPurpurStairs extends Item {

    public ItemPurpurStairs() {
        this(0, 1);
    }

    public ItemPurpurStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemPurpurStairs(Integer meta, int count) {
        super(ItemID.PURPUR_STAIRS, meta, count, "Purpur Stairs");
        this.block = Block.get(BlockID.PURPUR_STAIRS, meta);
    }
}