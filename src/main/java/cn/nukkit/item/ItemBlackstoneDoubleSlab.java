package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlackstoneDoubleSlab extends Item {

    public ItemBlackstoneDoubleSlab() {
        this(0, 1);
    }

    public ItemBlackstoneDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemBlackstoneDoubleSlab(Integer meta, int count) {
        super(ItemID.BLACKSTONE_DOUBLE_SLAB, meta, count, "Blackstone Double Slab");
        this.block = Block.get(BlockID.BLACKSTONE_DOUBLE_SLAB, meta);
    }
}