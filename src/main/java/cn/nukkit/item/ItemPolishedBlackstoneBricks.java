package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneBricks extends Item {

    public ItemPolishedBlackstoneBricks() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneBricks(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneBricks(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_BRICKS, meta, count, "Polished Blackstone Bricks");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_BRICKS, meta);
    }
}