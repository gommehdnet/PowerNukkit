package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCyanGlazedTerracotta extends Item {

    public ItemCyanGlazedTerracotta() {
        this(0, 1);
    }

    public ItemCyanGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemCyanGlazedTerracotta(Integer meta, int count) {
        super(ItemID.CYAN_GLAZED_TERRACOTTA, meta, count, "Cyan Glazed Terracotta");
        this.block = Block.get(BlockID.CYAN_GLAZED_TERRACOTTA, meta);
    }
}