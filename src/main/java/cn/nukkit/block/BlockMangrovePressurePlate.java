package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangrovePressurePlate extends BlockWoodenPressurePlate {

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_PRESSURE_PLATE;
    }

    @Override
    public String getName() {
        return "Mangrove Pressure Plate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_PRESSURE_PLATE);
    }
}