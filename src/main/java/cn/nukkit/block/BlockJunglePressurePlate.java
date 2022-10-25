package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockJunglePressurePlate extends BlockWoodenPressurePlate {

    @PowerNukkitOnly
    public BlockJunglePressurePlate() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockJunglePressurePlate(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.JUNGLE_PRESSURE_PLATE;
    }
    
    @Override
    public String getName() {
        return "Jungle Pressure Plate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.JUNGLE_PRESSURE_PLATE);
    }
}
