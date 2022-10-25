package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWoodenSlab extends Item {

    public ItemWoodenSlab() {
        this(0, 1);
    }

    public ItemWoodenSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWoodenSlab(Integer meta, int count) {
        super(ItemID.WOODEN_SLAB, meta, count, "Wooden Slab");
        this.block = Block.get(BlockID.WOODEN_SLAB, meta);
    }
}