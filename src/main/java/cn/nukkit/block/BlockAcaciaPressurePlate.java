package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockAcaciaPressurePlate extends BlockWoodenPressurePlate {

    @PowerNukkitOnly
    public BlockAcaciaPressurePlate() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockAcaciaPressurePlate(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.ACACIA_PRESSURE_PLATE;
    }
    
    @Override
    public String getName() {
        return "Acacia Pressure Plate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ACACIA_PRESSURE_PLATE);
    }
}
