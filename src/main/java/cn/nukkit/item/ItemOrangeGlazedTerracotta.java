package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOrangeGlazedTerracotta extends Item {

    public ItemOrangeGlazedTerracotta() {
        this(0, 1);
    }

    public ItemOrangeGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemOrangeGlazedTerracotta(Integer meta, int count) {
        super(ItemID.ORANGE_GLAZED_TERRACOTTA, meta, count, "Orange Glazed Terracotta");
        this.block = Block.get(BlockID.ORANGE_GLAZED_TERRACOTTA, meta);
    }
}