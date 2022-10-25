package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockLightBlueGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockLightBlueGlazedTerracotta() {
        this(0);
    }

    public BlockLightBlueGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.LIGHT_BLUE_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Light Blue Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.LIGHT_BLUE;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LIGHT_BLUE_GLAZED_TERRACOTTA);
    }
}
