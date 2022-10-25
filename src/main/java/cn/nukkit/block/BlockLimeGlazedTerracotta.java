package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockLimeGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockLimeGlazedTerracotta() {
        this(0);
    }

    public BlockLimeGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.LIME_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Lime Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.LIME;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LIME_GLAZED_TERRACOTTA);
    }
}
