package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDetectorRail extends Item {

    public ItemDetectorRail() {
        this(0, 1);
    }

    public ItemDetectorRail(Integer meta) {
        this(meta, 1);
    }

    public ItemDetectorRail(Integer meta, int count) {
        super(ItemID.DETECTOR_RAIL, meta, count, "Detector Rail");
        this.block = Block.get(BlockID.DETECTOR_RAIL, meta);
    }
}