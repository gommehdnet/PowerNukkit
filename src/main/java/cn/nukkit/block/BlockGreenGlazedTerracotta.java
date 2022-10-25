package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockGreenGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockGreenGlazedTerracotta() {
        this(0);
    }

    public BlockGreenGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.GREEN_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Green Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.GREEN;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.GREEN_GLAZED_TERRACOTTA);
    }
}
