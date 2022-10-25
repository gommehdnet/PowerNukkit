package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBrownGlazedTerracotta extends Item {

    public ItemBrownGlazedTerracotta() {
        this(0, 1);
    }

    public ItemBrownGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemBrownGlazedTerracotta(Integer meta, int count) {
        super(ItemID.BROWN_GLAZED_TERRACOTTA, meta, count, "Brown Glazed Terracotta");
        this.block = Block.get(BlockID.BROWN_GLAZED_TERRACOTTA, meta);
    }
}