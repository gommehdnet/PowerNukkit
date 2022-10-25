package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGrayGlazedTerracotta extends Item {

    public ItemGrayGlazedTerracotta() {
        this(0, 1);
    }

    public ItemGrayGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemGrayGlazedTerracotta(Integer meta, int count) {
        super(ItemID.GRAY_GLAZED_TERRACOTTA, meta, count, "Gray Glazed Terracotta");
        this.block = Block.get(BlockID.GRAY_GLAZED_TERRACOTTA, meta);
    }
}