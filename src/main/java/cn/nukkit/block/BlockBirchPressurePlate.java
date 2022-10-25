package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockBirchPressurePlate extends BlockWoodenPressurePlate {

    @PowerNukkitOnly
    public BlockBirchPressurePlate() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockBirchPressurePlate(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.BIRCH_PRESSURE_PLATE;
    }
    
    @Override
    public String getName() {
        return "Birch Pressure Plate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BIRCH_PRESSURE_PLATE);
    }
}
