package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBeacon extends Item {

    public ItemBeacon() {
        this(0, 1);
    }

    public ItemBeacon(Integer meta) {
        this(meta, 1);
    }

    public ItemBeacon(Integer meta, int count) {
        super(ItemID.BEACON, meta, count, "Beacon");
        this.block = Block.get(BlockID.BEACON, meta);
    }
}