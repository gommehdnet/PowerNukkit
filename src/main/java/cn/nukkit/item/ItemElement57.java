package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement57 extends Item {

    public ItemElement57() {
        this(0, 1);
    }

    public ItemElement57(Integer meta) {
        this(meta, 1);
    }

    public ItemElement57(Integer meta, int count) {
        super(ItemID.ELEMENT_57, meta, count, "Element 57");
        this.block = Block.get(BlockID.ELEMENT_57, meta);
    }
}