package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDaylightDetector extends Item {

    public ItemDaylightDetector() {
        this(0, 1);
    }

    public ItemDaylightDetector(Integer meta) {
        this(meta, 1);
    }

    public ItemDaylightDetector(Integer meta, int count) {
        super(ItemID.DAYLIGHT_DETECTOR, meta, count, "Daylight Detector");
        this.block = Block.get(BlockID.DAYLIGHT_DETECTOR, meta);
    }
}