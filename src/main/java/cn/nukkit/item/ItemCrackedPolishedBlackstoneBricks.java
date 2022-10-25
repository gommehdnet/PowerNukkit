package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrackedPolishedBlackstoneBricks extends Item {

    public ItemCrackedPolishedBlackstoneBricks() {
        this(0, 1);
    }

    public ItemCrackedPolishedBlackstoneBricks(Integer meta) {
        this(meta, 1);
    }

    public ItemCrackedPolishedBlackstoneBricks(Integer meta, int count) {
        super(ItemID.CRACKED_POLISHED_BLACKSTONE_BRICKS, meta, count, "Cracked Polished Blackstone Bricks");
        this.block = Block.get(BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS, meta);
    }
}