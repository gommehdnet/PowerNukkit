package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedNylium extends Item {

    public ItemWarpedNylium() {
        this(0, 1);
    }

    public ItemWarpedNylium(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedNylium(Integer meta, int count) {
        super(ItemID.WARPED_NYLIUM, meta, count, "Warped Nylium");
        this.block = Block.get(BlockID.WARPED_NYLIUM, meta);
    }
}