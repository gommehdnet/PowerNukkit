package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHardenedClay extends Item {

    public ItemHardenedClay() {
        this(0, 1);
    }

    public ItemHardenedClay(Integer meta) {
        this(meta, 1);
    }

    public ItemHardenedClay(Integer meta, int count) {
        super(ItemID.HARDENED_CLAY, meta, count, "Hardened Clay");
        this.block = Block.get(BlockID.HARDENED_CLAY, meta);
    }
}