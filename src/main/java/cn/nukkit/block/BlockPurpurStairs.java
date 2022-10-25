package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

public class BlockPurpurStairs extends BlockStairs {

    public BlockPurpurStairs() {
        this(0);
    }

    public BlockPurpurStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.PURPUR_STAIRS;
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
        return "Purpur Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.MAGENTA_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.PURPUR_STAIRS);
    }
}
