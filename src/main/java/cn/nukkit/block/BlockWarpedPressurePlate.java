package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockWarpedPressurePlate extends BlockWoodenPressurePlate {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockWarpedPressurePlate() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockWarpedPressurePlate(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.WARPED_PRESSURE_PLATE;
    }
    
    @Override
    public String getName() {
        return "Warped Pressure Plate";
    }
    
    @Override
    public int getBurnChance() {
        return 0;
    }
    
    @Override
    public int getBurnAbility() {
        return 0;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WARPED_PRESSURE_PLATE);
    }
}
