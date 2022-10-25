package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneDoubleSlab extends Item {

    public ItemPolishedBlackstoneDoubleSlab() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneDoubleSlab(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_DOUBLE_SLAB, meta, count, "Polished Blackstone Double Slab");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_DOUBLE_SLAB, meta);
    }
}