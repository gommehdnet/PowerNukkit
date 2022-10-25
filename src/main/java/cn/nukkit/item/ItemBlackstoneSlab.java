package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlackstoneSlab extends Item {

    public ItemBlackstoneSlab() {
        this(0, 1);
    }

    public ItemBlackstoneSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemBlackstoneSlab(Integer meta, int count) {
        super(ItemID.BLACKSTONE_SLAB, meta, count, "Blackstone Slab");
        this.block = Block.get(BlockID.BLACKSTONE_SLAB, meta);
    }
}