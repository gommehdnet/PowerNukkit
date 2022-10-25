package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockSprucePressurePlate extends BlockWoodenPressurePlate {

    @PowerNukkitOnly
    public BlockSprucePressurePlate() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockSprucePressurePlate(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.SPRUCE_PRESSURE_PLATE;
    }
    
    @Override
    public String getName() {
        return "Spruce Pressure Plate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SPRUCE_PRESSURE_PLATE);
    }
}
