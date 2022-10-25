package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockBlueGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockBlueGlazedTerracotta() {
        this(0);
    }

    public BlockBlueGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.BLUE_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Blue Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.BLUE;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BLUE_GLAZED_TERRACOTTA);
    }
}
