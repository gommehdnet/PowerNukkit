package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
public class BlockSmoothQuartzStairs extends BlockStairs {
    @PowerNukkitOnly
    public BlockSmoothQuartzStairs() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockSmoothQuartzStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SMOOTH_QUARTZ_STAIRS;
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
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    @PowerNukkitOnly
    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }

    @Override
    public String getName() {
        return "Smooth Quartz Brick Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.QUARTZ_BLOCK_COLOR;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SMOOTH_QUARTZ_STAIRS);
    }
}
