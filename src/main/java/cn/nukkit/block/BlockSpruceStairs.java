package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/25
 */
public class BlockSpruceStairs extends BlockOakStairs {

    public BlockSpruceStairs() {
        this(0);
    }

    public BlockSpruceStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SPRUCE_STAIRS;
    }

    @Override
    public String getName() {
        return "Spruce Wood Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.SPRUCE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SPRUCE_STAIRS);
    }

}
