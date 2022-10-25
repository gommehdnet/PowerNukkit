package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

@PowerNukkitOnly
public class BlockSmoothStone extends BlockSolid {

    @PowerNukkitOnly
    public BlockSmoothStone() {
    }
    
    @Override
    public BlockID getId() {
        return BlockID.SMOOTH_STONE;
    }
    
    @Override
    public String getName() {
        return "Smooth Stone";
    }
    
    @Override
    public double getHardness() {
        return 1.5;
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
        return Item.get(ItemID.SMOOTH_STONE);
    }

}
