package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockOrangeGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockOrangeGlazedTerracotta() {
        this(0);
    }

    public BlockOrangeGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.ORANGE_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Orange Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.ORANGE;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ORANGE_GLAZED_TERRACOTTA);
    }
}
