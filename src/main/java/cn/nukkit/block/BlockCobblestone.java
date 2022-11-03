package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

/**
 * @author Angelic47 (Nukkit Project)
 */
public class BlockCobblestone extends BlockSolid {

    public BlockCobblestone() {
    }

    @Override
    public BlockID getId() {
        return BlockID.COBBLESTONE;
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
    public String getName() {
        return "Cobblestone";
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
    public Item[] getDrops(Item item) {
        if (item.isPickaxe()) {
            return new Item[]{this.toItem()};
        }

        return Item.EMPTY_ARRAY;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COBBLESTONE);
    }
}
