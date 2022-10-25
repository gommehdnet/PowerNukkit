package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedCrimsonStem extends Item {

    public ItemStrippedCrimsonStem() {
        this(0, 1);
    }

    public ItemStrippedCrimsonStem(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedCrimsonStem(Integer meta, int count) {
        super(ItemID.STRIPPED_CRIMSON_STEM, meta, count, "Stripped Crimson Stem");
        this.block = Block.get(BlockID.STRIPPED_CRIMSON_STEM, meta);
    }
}