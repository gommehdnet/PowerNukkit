package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPinkGlazedTerracotta extends Item {

    public ItemPinkGlazedTerracotta() {
        this(0, 1);
    }

    public ItemPinkGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemPinkGlazedTerracotta(Integer meta, int count) {
        super(ItemID.PINK_GLAZED_TERRACOTTA, meta, count, "Pink Glazed Terracotta");
        this.block = Block.get(BlockID.PINK_GLAZED_TERRACOTTA, meta);
    }
}