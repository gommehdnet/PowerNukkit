package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightBlueGlazedTerracotta extends Item {

    public ItemLightBlueGlazedTerracotta() {
        this(0, 1);
    }

    public ItemLightBlueGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemLightBlueGlazedTerracotta(Integer meta, int count) {
        super(ItemID.LIGHT_BLUE_GLAZED_TERRACOTTA, meta, count, "Light Blue Glazed Terracotta");
        this.block = Block.get(BlockID.LIGHT_BLUE_GLAZED_TERRACOTTA, meta);
    }
}