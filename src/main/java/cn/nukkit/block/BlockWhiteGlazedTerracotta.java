package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockWhiteGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockWhiteGlazedTerracotta() {
        this(0);
    }

    public BlockWhiteGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WHITE_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "White Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.WHITE;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WHITE_GLAZED_TERRACOTTA);
    }
}
