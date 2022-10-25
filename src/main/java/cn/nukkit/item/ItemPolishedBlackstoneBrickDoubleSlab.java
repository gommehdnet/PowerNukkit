package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneBrickDoubleSlab extends Item {

    public ItemPolishedBlackstoneBrickDoubleSlab() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneBrickDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneBrickDoubleSlab(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_BRICK_DOUBLE_SLAB, meta, count, "Polished Blackstone Brick Double Slab");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_BRICK_DOUBLE_SLAB, meta);
    }
}