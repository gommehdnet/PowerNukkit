package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMagentaGlazedTerracotta extends Item {

    public ItemMagentaGlazedTerracotta() {
        this(0, 1);
    }

    public ItemMagentaGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemMagentaGlazedTerracotta(Integer meta, int count) {
        super(ItemID.MAGENTA_GLAZED_TERRACOTTA, meta, count, "Magenta Glazed Terracotta");
        this.block = Block.get(BlockID.MAGENTA_GLAZED_TERRACOTTA, meta);
    }
}