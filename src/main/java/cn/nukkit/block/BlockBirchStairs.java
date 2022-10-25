package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/25
 */
public class BlockBirchStairs extends BlockOakStairs {

    public BlockBirchStairs() {
        this(0);
    }

    public BlockBirchStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.BIRCH_STAIRS;
    }

    @Override
    public String getName() {
        return "Birch Wood Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.SAND_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BIRCH_STAIRS);
    }

}
