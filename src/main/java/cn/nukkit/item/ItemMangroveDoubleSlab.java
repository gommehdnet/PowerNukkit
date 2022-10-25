package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveDoubleSlab extends Item {

    public ItemMangroveDoubleSlab() {
        this(0, 1);
    }

    public ItemMangroveDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveDoubleSlab(Integer meta, int count) {
        super(ItemID.MANGROVE_DOUBLE_SLAB, meta, count, "Mangrove Double Slab");
        this.block = Block.get(BlockID.MANGROVE_DOUBLE_SLAB, meta);
    }
}