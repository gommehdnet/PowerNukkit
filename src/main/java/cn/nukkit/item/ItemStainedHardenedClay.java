package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStainedHardenedClay extends Item {

    public ItemStainedHardenedClay() {
        this(0, 1);
    }

    public ItemStainedHardenedClay(Integer meta) {
        this(meta, 1);
    }

    public ItemStainedHardenedClay(Integer meta, int count) {
        super(ItemID.STAINED_HARDENED_CLAY, meta, count, "Stained Hardened Clay");
        this.block = Block.get(BlockID.STAINED_HARDENED_CLAY, meta);
    }
}