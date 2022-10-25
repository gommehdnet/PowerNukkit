package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHeavyWeightedPressurePlate extends Item {

    public ItemHeavyWeightedPressurePlate() {
        this(0, 1);
    }

    public ItemHeavyWeightedPressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemHeavyWeightedPressurePlate(Integer meta, int count) {
        super(ItemID.HEAVY_WEIGHTED_PRESSURE_PLATE, meta, count, "Heavy Weighted Pressure Plate");
        this.block = Block.get(BlockID.HEAVY_WEIGHTED_PRESSURE_PLATE, meta);
    }
}