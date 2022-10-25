package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBirchPressurePlate extends Item {

    public ItemBirchPressurePlate() {
        this(0, 1);
    }

    public ItemBirchPressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchPressurePlate(Integer meta, int count) {
        super(ItemID.BIRCH_PRESSURE_PLATE, meta, count, "Birch Pressure Plate");
        this.block = Block.get(BlockID.BIRCH_PRESSURE_PLATE, meta);
    }
}