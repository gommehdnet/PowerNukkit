package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDaylightDetectorInverted extends Item {

    public ItemDaylightDetectorInverted() {
        this(0, 1);
    }

    public ItemDaylightDetectorInverted(Integer meta) {
        this(meta, 1);
    }

    public ItemDaylightDetectorInverted(Integer meta, int count) {
        super(ItemID.DAYLIGHT_DETECTOR_INVERTED, meta, count, "Daylight Detector Inverted");
        this.block = Block.get(BlockID.DAYLIGHT_DETECTOR_INVERTED, meta);
    }
}