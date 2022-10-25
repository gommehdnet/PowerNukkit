package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockBrownGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockBrownGlazedTerracotta() {
        this(0);
    }

    public BlockBrownGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.BROWN_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Brown Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.BROWN;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BROWN_GLAZED_TERRACOTTA);
    }
}
