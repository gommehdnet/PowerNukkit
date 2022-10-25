package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedGlazedTerracotta extends Item {

    public ItemRedGlazedTerracotta() {
        this(0, 1);
    }

    public ItemRedGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemRedGlazedTerracotta(Integer meta, int count) {
        super(ItemID.RED_GLAZED_TERRACOTTA, meta, count, "Red Glazed Terracotta");
        this.block = Block.get(BlockID.RED_GLAZED_TERRACOTTA, meta);
    }
}