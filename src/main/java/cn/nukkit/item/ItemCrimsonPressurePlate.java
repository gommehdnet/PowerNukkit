package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonPressurePlate extends Item {

    public ItemCrimsonPressurePlate() {
        this(0, 1);
    }

    public ItemCrimsonPressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonPressurePlate(Integer meta, int count) {
        super(ItemID.CRIMSON_PRESSURE_PLATE, meta, count, "Crimson Pressure Plate");
        this.block = Block.get(BlockID.CRIMSON_PRESSURE_PLATE, meta);
    }
}