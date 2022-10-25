package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightWeightedPressurePlate extends Item {

    public ItemLightWeightedPressurePlate() {
        this(0, 1);
    }

    public ItemLightWeightedPressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemLightWeightedPressurePlate(Integer meta, int count) {
        super(ItemID.LIGHT_WEIGHTED_PRESSURE_PLATE, meta, count, "Light Weighted Pressure Plate");
        this.block = Block.get(BlockID.LIGHT_WEIGHTED_PRESSURE_PLATE, meta);
    }
}