package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWhiteGlazedTerracotta extends Item {

    public ItemWhiteGlazedTerracotta() {
        this(0, 1);
    }

    public ItemWhiteGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemWhiteGlazedTerracotta(Integer meta, int count) {
        super(ItemID.WHITE_GLAZED_TERRACOTTA, meta, count, "White Glazed Terracotta");
        this.block = Block.get(BlockID.WHITE_GLAZED_TERRACOTTA, meta);
    }
}