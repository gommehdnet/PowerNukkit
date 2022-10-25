package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStonePressurePlate extends Item {

    public ItemStonePressurePlate() {
        this(0, 1);
    }

    public ItemStonePressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemStonePressurePlate(Integer meta, int count) {
        super(ItemID.STONE_PRESSURE_PLATE, meta, count, "Stone Pressure Plate");
        this.block = Block.get(BlockID.STONE_PRESSURE_PLATE, meta);
    }
}