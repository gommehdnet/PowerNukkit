package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedStem extends Item {

    public ItemWarpedStem() {
        this(0, 1);
    }

    public ItemWarpedStem(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedStem(Integer meta, int count) {
        super(ItemID.WARPED_STEM, meta, count, "Warped Stem");
        this.block = Block.get(BlockID.WARPED_STEM, meta);
    }
}