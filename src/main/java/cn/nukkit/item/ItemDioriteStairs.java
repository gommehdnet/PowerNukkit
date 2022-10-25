package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDioriteStairs extends Item {

    public ItemDioriteStairs() {
        this(0, 1);
    }

    public ItemDioriteStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemDioriteStairs(Integer meta, int count) {
        super(ItemID.DIORITE_STAIRS, meta, count, "Diorite Stairs");
        this.block = Block.get(BlockID.DIORITE_STAIRS, meta);
    }
}