package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

/**
 * @author CreeperFace
 * @since 26. 11. 2016
 */
public class BlockRedSandstoneStairs extends BlockStairs {

    public BlockRedSandstoneStairs() {
        this(0);
    }

    public BlockRedSandstoneStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.RED_SANDSTONE_STAIRS;
    }

    @Override
    public double getHardness() {
        return 0.8;
    }

    @Override
    public double getResistance() {
        return 4;
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
        return "Red Sandstone Stairs";
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.ORANGE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RED_SANDSTONE_STAIRS);
    }
}
