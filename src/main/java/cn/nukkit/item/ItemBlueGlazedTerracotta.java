package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlueGlazedTerracotta extends Item {

    public ItemBlueGlazedTerracotta() {
        this(0, 1);
    }

    public ItemBlueGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemBlueGlazedTerracotta(Integer meta, int count) {
        super(ItemID.BLUE_GLAZED_TERRACOTTA, meta, count, "Blue Glazed Terracotta");
        this.block = Block.get(BlockID.BLUE_GLAZED_TERRACOTTA, meta);
    }
}