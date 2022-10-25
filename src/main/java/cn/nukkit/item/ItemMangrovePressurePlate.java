package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangrovePressurePlate extends Item {

    public ItemMangrovePressurePlate() {
        this(0, 1);
    }

    public ItemMangrovePressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemMangrovePressurePlate(Integer meta, int count) {
        super(ItemID.MANGROVE_PRESSURE_PLATE, meta, count, "Mangrove Pressure Plate");
        this.block = Block.get(BlockID.MANGROVE_PRESSURE_PLATE, meta);
    }
}