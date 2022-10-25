package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

/**
 * @author xtypr
 * @since 2015/12/2
 */
public class BlockMossyCobblestone extends BlockSolid {

    public BlockMossyCobblestone() {
    }

    @Override
    public String getName() {
        return "Moss Stone";
    }

    @Override
    public BlockID getId() {
        return BlockID.MOSSY_COBBLESTONE;
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public double getResistance() {
        return 10;
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
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MOSSY_COBBLESTONE);
    }
}
