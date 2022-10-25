package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWoodenPressurePlate extends Item {

    public ItemWoodenPressurePlate() {
        this(0, 1);
    }

    public ItemWoodenPressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemWoodenPressurePlate(Integer meta, int count) {
        super(ItemID.WOODEN_PRESSURE_PLATE, meta, count, "Wooden Pressure Plate");
        this.block = Block.get(BlockID.WOODEN_PRESSURE_PLATE, meta);
    }
}