package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneStairs extends Item {

    public ItemPolishedBlackstoneStairs() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneStairs(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_STAIRS, meta, count, "Polished Blackstone Stairs");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_STAIRS, meta);
    }
}