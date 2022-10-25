package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlackstoneStairs extends Item {

    public ItemBlackstoneStairs() {
        this(0, 1);
    }

    public ItemBlackstoneStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemBlackstoneStairs(Integer meta, int count) {
        super(ItemID.BLACKSTONE_STAIRS, meta, count, "Blackstone Stairs");
        this.block = Block.get(BlockID.BLACKSTONE_STAIRS, meta);
    }
}