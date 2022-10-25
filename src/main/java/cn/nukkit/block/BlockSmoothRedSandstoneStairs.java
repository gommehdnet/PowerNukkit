package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
public class BlockSmoothRedSandstoneStairs extends BlockStairs {
    @PowerNukkitOnly
    public BlockSmoothRedSandstoneStairs() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockSmoothRedSandstoneStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SMOOTH_RED_SANDSTONE_STAIRS;
    }

    @Override
    public double getHardness() {
        return 2;
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
        return "Smooth Red Sandstone Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.ORANGE_BLOCK_COLOR;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SMOOTH_RED_SANDSTONE_STAIRS);
    }
}
