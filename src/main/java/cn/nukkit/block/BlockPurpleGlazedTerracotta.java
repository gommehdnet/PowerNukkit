package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockPurpleGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockPurpleGlazedTerracotta() {
        this(0);
    }

    public BlockPurpleGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.PURPLE_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Purple Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.PURPLE;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.PURPLE_GLAZED_TERRACOTTA);
    }
}
