package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLimeGlazedTerracotta extends Item {

    public ItemLimeGlazedTerracotta() {
        this(0, 1);
    }

    public ItemLimeGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemLimeGlazedTerracotta(Integer meta, int count) {
        super(ItemID.LIME_GLAZED_TERRACOTTA, meta, count, "Lime Glazed Terracotta");
        this.block = Block.get(BlockID.LIME_GLAZED_TERRACOTTA, meta);
    }
}