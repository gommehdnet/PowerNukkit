package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockSilverGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockSilverGlazedTerracotta() {
        this(0);
    }

    public BlockSilverGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SILVER_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Light Gray Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.LIGHT_GRAY;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SILVER_GLAZED_TERRACOTTA);
    }
}
