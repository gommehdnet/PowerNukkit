package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockYellowGlazedTerracotta extends BlockTerracottaGlazed {

    public BlockYellowGlazedTerracotta() {
        this(0);
    }

    public BlockYellowGlazedTerracotta(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.YELLOW_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Yellow Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.YELLOW;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.YELLOW_GLAZED_TERRACOTTA);
    }
}
