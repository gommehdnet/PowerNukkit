package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonDoubleSlab extends Item {

    public ItemCrimsonDoubleSlab() {
        this(0, 1);
    }

    public ItemCrimsonDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonDoubleSlab(Integer meta, int count) {
        super(ItemID.CRIMSON_DOUBLE_SLAB, meta, count, "Crimson Double Slab");
        this.block = Block.get(BlockID.CRIMSON_DOUBLE_SLAB, meta);
    }
}