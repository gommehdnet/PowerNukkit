package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockBlueIce extends BlockPackedIce {

    @PowerNukkitOnly
    public BlockBlueIce() {
    }
    
    @Override
    public BlockID getId() {
        return BlockID.BLUE_ICE;
    }
    
    @Override
    public String getName() {
        return "Blue Ice";
    }
    
    @Override
    public double getFrictionFactor() {
        return 0.989;
    }
    
    @Override
    public double getHardness() {
        return 2.8;
    }

    @Override
    public double getResistance() {
        return 14;
    }

    @Override
    public boolean isTransparent() {
        return false;
    }
    
    
    @Override
    public int getLightLevel() {
        return 4;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BLUE_ICE);
    }
}
