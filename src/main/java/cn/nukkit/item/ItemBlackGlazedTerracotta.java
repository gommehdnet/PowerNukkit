package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlackGlazedTerracotta extends Item {

    public ItemBlackGlazedTerracotta() {
        this(0, 1);
    }

    public ItemBlackGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemBlackGlazedTerracotta(Integer meta, int count) {
        super(ItemID.BLACK_GLAZED_TERRACOTTA, meta, count, "Black Glazed Terracotta");
        this.block = Block.get(BlockID.BLACK_GLAZED_TERRACOTTA, meta);
    }
}