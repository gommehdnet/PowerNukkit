package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveTrapdoor extends Item {

    public ItemMangroveTrapdoor() {
        this(0, 1);
    }

    public ItemMangroveTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveTrapdoor(Integer meta, int count) {
        super(ItemID.MANGROVE_TRAPDOOR, meta, count, "Mangrove Trapdoor");
        this.block = Block.get(BlockID.MANGROVE_TRAPDOOR, meta);
    }
}