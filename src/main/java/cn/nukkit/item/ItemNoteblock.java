package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNoteblock extends Item {

    public ItemNoteblock() {
        this(0, 1);
    }

    public ItemNoteblock(Integer meta) {
        this(meta, 1);
    }

    public ItemNoteblock(Integer meta, int count) {
        super(ItemID.NOTEBLOCK, meta, count, "Noteblock");
        this.block = Block.get(BlockID.NOTEBLOCK, meta);
    }
}