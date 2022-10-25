package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPurpleGlazedTerracotta extends Item {

    public ItemPurpleGlazedTerracotta() {
        this(0, 1);
    }

    public ItemPurpleGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemPurpleGlazedTerracotta(Integer meta, int count) {
        super(ItemID.PURPLE_GLAZED_TERRACOTTA, meta, count, "Purple Glazed Terracotta");
        this.block = Block.get(BlockID.PURPLE_GLAZED_TERRACOTTA, meta);
    }
}