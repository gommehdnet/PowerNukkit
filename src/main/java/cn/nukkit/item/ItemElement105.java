package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement105 extends Item {

    public ItemElement105() {
        this(0, 1);
    }

    public ItemElement105(Integer meta) {
        this(meta, 1);
    }

    public ItemElement105(Integer meta, int count) {
        super(ItemID.ELEMENT_105, meta, count, "Element 105");
        this.block = Block.get(BlockID.ELEMENT_105, meta);
    }
}