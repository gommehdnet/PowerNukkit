package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockDarkOakPressurePlate extends BlockWoodenPressurePlate {

    @PowerNukkitOnly
    public BlockDarkOakPressurePlate() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockDarkOakPressurePlate(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.DARK_OAK_PRESSURE_PLATE;
    }
    
    @Override
    public String getName() {
        return "Dark Oak Pressure Plate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DARK_OAK_PRESSURE_PLATE);
    }
}
