package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDoubleWoodenSlab extends Item {

    public ItemDoubleWoodenSlab() {
        this(0, 1);
    }

    public ItemDoubleWoodenSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemDoubleWoodenSlab(Integer meta, int count) {
        super(ItemID.DOUBLE_WOODEN_SLAB, meta, count, "Double Wooden Slab");
        this.block = Block.get(BlockID.DOUBLE_WOODEN_SLAB, meta);
    }
}