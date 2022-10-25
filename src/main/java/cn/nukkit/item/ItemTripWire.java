package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTripWire extends Item {

    public ItemTripWire() {
        this(0, 1);
    }

    public ItemTripWire(Integer meta) {
        this(meta, 1);
    }

    public ItemTripWire(Integer meta, int count) {
        super(ItemID.TRIP_WIRE, meta, count, "Trip Wire");
        this.block = Block.get(BlockID.TRIP_WIRE, meta);
    }
}