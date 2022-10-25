package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneSlab extends Item {

    public ItemPolishedBlackstoneSlab() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneSlab(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_SLAB, meta, count, "Polished Blackstone Slab");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_SLAB, meta);
    }
}