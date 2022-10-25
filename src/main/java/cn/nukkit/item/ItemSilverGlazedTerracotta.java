package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSilverGlazedTerracotta extends Item {

    public ItemSilverGlazedTerracotta() {
        this(0, 1);
    }

    public ItemSilverGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemSilverGlazedTerracotta(Integer meta, int count) {
        super(ItemID.SILVER_GLAZED_TERRACOTTA, meta, count, "Silver Glazed Terracotta");
        this.block = Block.get(BlockID.SILVER_GLAZED_TERRACOTTA, meta);
    }
}