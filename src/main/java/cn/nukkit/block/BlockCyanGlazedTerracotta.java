package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockCyanGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockCyanGlazedTerracotta() {
        this(0);
    }

    public BlockCyanGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.CYAN_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Cyan Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.CYAN;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CYAN_GLAZED_TERRACOTTA);
    }
}
