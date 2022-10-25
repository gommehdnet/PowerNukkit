package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedPressurePlate extends Item {

    public ItemWarpedPressurePlate() {
        this(0, 1);
    }

    public ItemWarpedPressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedPressurePlate(Integer meta, int count) {
        super(ItemID.WARPED_PRESSURE_PLATE, meta, count, "Warped Pressure Plate");
        this.block = Block.get(BlockID.WARPED_PRESSURE_PLATE, meta);
    }
}