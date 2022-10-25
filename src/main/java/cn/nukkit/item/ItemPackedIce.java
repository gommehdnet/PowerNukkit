package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPackedIce extends Item {

    public ItemPackedIce() {
        this(0, 1);
    }

    public ItemPackedIce(Integer meta) {
        this(meta, 1);
    }

    public ItemPackedIce(Integer meta, int count) {
        super(ItemID.PACKED_ICE, meta, count, "Packed Ice");
        this.block = Block.get(BlockID.PACKED_ICE, meta);
    }
}