package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBookshelf extends Item {

    public ItemBookshelf() {
        this(0, 1);
    }

    public ItemBookshelf(Integer meta) {
        this(meta, 1);
    }

    public ItemBookshelf(Integer meta, int count) {
        super(ItemID.BOOKSHELF, meta, count, "Bookshelf");
        this.block = Block.get(BlockID.BOOKSHELF, meta);
    }
}