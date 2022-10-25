package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGreenGlazedTerracotta extends Item {

    public ItemGreenGlazedTerracotta() {
        this(0, 1);
    }

    public ItemGreenGlazedTerracotta(Integer meta) {
        this(meta, 1);
    }

    public ItemGreenGlazedTerracotta(Integer meta, int count) {
        super(ItemID.GREEN_GLAZED_TERRACOTTA, meta, count, "Green Glazed Terracotta");
        this.block = Block.get(BlockID.GREEN_GLAZED_TERRACOTTA, meta);
    }
}