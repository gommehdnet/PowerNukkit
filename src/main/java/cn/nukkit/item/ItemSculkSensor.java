package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSculkSensor extends Item {

    public ItemSculkSensor() {
        this(0, 1);
    }

    public ItemSculkSensor(Integer meta) {
        this(meta, 1);
    }

    public ItemSculkSensor(Integer meta, int count) {
        super(ItemID.SCULK_SENSOR, meta, count, "Sculk Sensor");
        this.block = Block.get(BlockID.SCULK_SENSOR, meta);
    }
}