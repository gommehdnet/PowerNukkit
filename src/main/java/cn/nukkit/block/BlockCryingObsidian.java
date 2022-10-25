package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

/**
 * @author good777LUCKY
 */
@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockCryingObsidian extends BlockSolid {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockCryingObsidian() {
        // Does nothing
    }
    
    @Override
    public BlockID getId() {
        return BlockID.CRYING_OBSIDIAN;
    }
    
    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }
    
    @Override
    public String getName() {
        return "Crying Obsidian";
    }
    
    @Override
    public double getHardness() {
        return 50;
    }
    
    @Override
    public double getResistance() {
        return 1200;
    }
    
    @Override
    public int getLightLevel() {
        return 10;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getToolTier() {
        return ItemTool.TIER_DIAMOND;
    }
    
    @Override
    public boolean canBePushed() {
        return false;
    }
    
    @Override
    @PowerNukkitOnly
    public  boolean canBePulled() {
        return false;
    }
    
    @Override
    public boolean canHarvestWithHand() {
        return false;
    }
    
    @Override
    public BlockColor getColor() {
        return BlockColor.BLACK_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CRYING_OBSIDIAN);
    }
}
