package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockRedGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockRedGlazedTerracotta() {
        this(0);
    }

    public BlockRedGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.RED_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Red Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.RED;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RED_GLAZED_TERRACOTTA);
    }
}
