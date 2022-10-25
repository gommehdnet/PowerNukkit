package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedWarpedStem extends Item {

    public ItemStrippedWarpedStem() {
        this(0, 1);
    }

    public ItemStrippedWarpedStem(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedWarpedStem(Integer meta, int count) {
        super(ItemID.STRIPPED_WARPED_STEM, meta, count, "Stripped Warped Stem");
        this.block = Block.get(BlockID.STRIPPED_WARPED_STEM, meta);
    }
}