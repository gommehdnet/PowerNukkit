package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockMagentaGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockMagentaGlazedTerracotta() {
        this(0);
    }

    public BlockMagentaGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.MAGENTA_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Magenta Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.MAGENTA;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MAGENTA_GLAZED_TERRACOTTA);
    }
}
