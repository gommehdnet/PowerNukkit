package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemYellowGlazedTerracotta extends Item {

    public ItemYellowGlazedTerracotta() {
        this(0, 1);
    }

    public ItemYellowGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemYellowGlazedTerracotta(Integer meta, int count) {
        super(ItemID.YELLOW_GLAZED_TERRACOTTA, meta, count, "Yellow Glazed Terracotta");
        this.block = Block.get(BlockID.YELLOW_GLAZED_TERRACOTTA, meta);
    }
}