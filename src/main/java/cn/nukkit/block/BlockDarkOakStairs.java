package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/25
 */
public class BlockDarkOakStairs extends BlockOakStairs {

    public BlockDarkOakStairs() {
        this(0);
    }

    public BlockDarkOakStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.DARK_OAK_STAIRS;
    }

    @Override
    public String getName() {
        return "Dark Oak Wood Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.BROWN_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DARK_OAK_STAIRS);
    }

}
