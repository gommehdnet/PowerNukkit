package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPrismarineBricksStairs extends BlockStairs {

    @PowerNukkitOnly
    public BlockPrismarineBricksStairs() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockPrismarineBricksStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.PRISMARINE_BRICKS_STAIRS;
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
        return "Prismarine Brick Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.DIAMOND_BLOCK_COLOR;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.PRISMARINE_BRICKS_STAIRS);
    }
}