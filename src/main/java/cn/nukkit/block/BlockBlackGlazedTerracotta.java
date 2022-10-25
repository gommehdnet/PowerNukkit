package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockBlackGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockBlackGlazedTerracotta() {
        this(0);
    }

    public BlockBlackGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.BLACK_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Black Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.BLACK;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BLACK_GLAZED_TERRACOTTA);
    }
}
