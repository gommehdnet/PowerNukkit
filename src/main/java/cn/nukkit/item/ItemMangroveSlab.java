package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveSlab extends Item {

    public ItemMangroveSlab() {
        this(0, 1);
    }

    public ItemMangroveSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveSlab(Integer meta, int count) {
        super(ItemID.MANGROVE_SLAB, meta, count, "Mangrove Slab");
        this.block = Block.get(BlockID.MANGROVE_SLAB, meta);
    }
}