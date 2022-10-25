package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedDioriteStairs extends Item {

    public ItemPolishedDioriteStairs() {
        this(0, 1);
    }

    public ItemPolishedDioriteStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedDioriteStairs(Integer meta, int count) {
        super(ItemID.POLISHED_DIORITE_STAIRS, meta, count, "Polished Diorite Stairs");
        this.block = Block.get(BlockID.POLISHED_DIORITE_STAIRS, meta);
    }
}