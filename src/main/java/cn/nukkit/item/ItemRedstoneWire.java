package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedstoneWire extends Item {

    public ItemRedstoneWire() {
        this(0, 1);
    }

    public ItemRedstoneWire(Integer meta) {
        this(meta, 1);
    }

    public ItemRedstoneWire(Integer meta, int count) {
        super(ItemID.REDSTONE_WIRE, meta, count, "Redstone Wire");
        this.block = Block.get(BlockID.REDSTONE_WIRE, meta);
    }
}