package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveRoots extends Item {

    public ItemMangroveRoots() {
        this(0, 1);
    }

    public ItemMangroveRoots(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveRoots(Integer meta, int count) {
        super(ItemID.MANGROVE_ROOTS, meta, count, "Mangrove Roots");
        this.block = Block.get(BlockID.MANGROVE_ROOTS, meta);
    }
}