package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSprucePressurePlate extends Item {

    public ItemSprucePressurePlate() {
        this(0, 1);
    }

    public ItemSprucePressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemSprucePressurePlate(Integer meta, int count) {
        super(ItemID.SPRUCE_PRESSURE_PLATE, meta, count, "Spruce Pressure Plate");
        this.block = Block.get(BlockID.SPRUCE_PRESSURE_PLATE, meta);
    }
}