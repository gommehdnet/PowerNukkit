package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMuddyMangroveRoots extends Item {

    public ItemMuddyMangroveRoots() {
        this(0, 1);
    }

    public ItemMuddyMangroveRoots(Integer meta) {
        this(meta, 1);
    }

    public ItemMuddyMangroveRoots(Integer meta, int count) {
        super(ItemID.MUDDY_MANGROVE_ROOTS, meta, count, "Muddy Mangrove Roots");
        this.block = Block.get(BlockID.MUDDY_MANGROVE_ROOTS, meta);
    }
}