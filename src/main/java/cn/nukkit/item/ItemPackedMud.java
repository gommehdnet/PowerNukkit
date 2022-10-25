package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPackedMud extends Item {

    public ItemPackedMud() {
        this(0, 1);
    }

    public ItemPackedMud(Integer meta) {
        this(meta, 1);
    }

    public ItemPackedMud(Integer meta, int count) {
        super(ItemID.PACKED_MUD, meta, count, "Packed Mud");
        this.block = Block.get(BlockID.PACKED_MUD, meta);
    }
}