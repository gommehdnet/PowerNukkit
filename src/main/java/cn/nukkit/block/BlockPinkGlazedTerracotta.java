package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPinkGlazedTerracotta extends BlockTerracottaGlazed {

    @Override
    public BlockID getId() {
        return BlockID.PINK_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Pink Glazed Terracotta";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.PINK_GLAZED_TERRACOTTA);
    }
}