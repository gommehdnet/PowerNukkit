package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJunglePressurePlate extends Item {

    public ItemJunglePressurePlate() {
        this(0, 1);
    }

    public ItemJunglePressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemJunglePressurePlate(Integer meta, int count) {
        super(ItemID.JUNGLE_PRESSURE_PLATE, meta, count, "Jungle Pressure Plate");
        this.block = Block.get(BlockID.JUNGLE_PRESSURE_PLATE, meta);
    }
}