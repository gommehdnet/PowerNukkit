package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonSlab extends Item {

    public ItemCrimsonSlab() {
        this(0, 1);
    }

    public ItemCrimsonSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonSlab(Integer meta, int count) {
        super(ItemID.CRIMSON_SLAB, meta, count, "Crimson Slab");
        this.block = Block.get(BlockID.CRIMSON_SLAB, meta);
    }
}