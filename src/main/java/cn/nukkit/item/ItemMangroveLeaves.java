package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveLeaves extends Item {

    public ItemMangroveLeaves() {
        this(0, 1);
    }

    public ItemMangroveLeaves(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveLeaves(Integer meta, int count) {
        super(ItemID.MANGROVE_LEAVES, meta, count, "Mangrove Leaves");
        this.block = Block.get(BlockID.MANGROVE_LEAVES, meta);
    }
}