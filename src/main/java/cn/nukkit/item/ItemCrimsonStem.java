package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonStem extends Item {

    public ItemCrimsonStem() {
        this(0, 1);
    }

    public ItemCrimsonStem(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonStem(Integer meta, int count) {
        super(ItemID.CRIMSON_STEM, meta, count, "Crimson Stem");
        this.block = Block.get(BlockID.CRIMSON_STEM, meta);
    }
}