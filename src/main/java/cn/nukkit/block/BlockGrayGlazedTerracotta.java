package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockGrayGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockGrayGlazedTerracotta() {
        this(0);
    }

    public BlockGrayGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.GRAY_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Gray Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.GRAY;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.GRAY_GLAZED_TERRACOTTA);
    }
}
