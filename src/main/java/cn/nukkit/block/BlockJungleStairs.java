package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/25
 */
public class BlockJungleStairs extends BlockOakStairs {

    public BlockJungleStairs() {
        this(0);
    }

    public BlockJungleStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.JUNGLE_STAIRS;
    }

    @Override
    public String getName() {
        return "Jungle Wood Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.DIRT_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.JUNGLE_STAIRS);
    }

}
