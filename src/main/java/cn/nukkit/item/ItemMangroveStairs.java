package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveStairs extends Item {

    public ItemMangroveStairs() {
        this(0, 1);
    }

    public ItemMangroveStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveStairs(Integer meta, int count) {
        super(ItemID.MANGROVE_STAIRS, meta, count, "Mangrove Stairs");
        this.block = Block.get(BlockID.MANGROVE_STAIRS, meta);
    }
}