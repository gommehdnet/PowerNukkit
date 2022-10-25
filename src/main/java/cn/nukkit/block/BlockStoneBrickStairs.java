package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/25
 */
public class BlockStoneBrickStairs extends BlockStairs {
    public BlockStoneBrickStairs() {
        this(0);
    }

    public BlockStoneBrickStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.STONE_BRICK_STAIRS;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    @PowerNukkitOnly
    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 30;
    }

    @Override
    public String getName() {
        return "Stone Brick Stairs";
    }

    @PowerNukkitDifference(info = "Fixed the color", since = "1.3.0.0-PN")
    @Override
    public BlockColor getColor() {
        return BlockColor.STONE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STONE_BRICK_STAIRS);
    }
}
