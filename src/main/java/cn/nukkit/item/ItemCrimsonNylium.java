package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonNylium extends Item {

    public ItemCrimsonNylium() {
        this(0, 1);
    }

    public ItemCrimsonNylium(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonNylium(Integer meta, int count) {
        super(ItemID.CRIMSON_NYLIUM, meta, count, "Crimson Nylium");
        this.block = Block.get(BlockID.CRIMSON_NYLIUM, meta);
    }
}