package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneBrickSlab extends Item {

    public ItemPolishedBlackstoneBrickSlab() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneBrickSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneBrickSlab(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_BRICK_SLAB, meta, count, "Polished Blackstone Brick Slab");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_BRICK_SLAB, meta);
    }
}