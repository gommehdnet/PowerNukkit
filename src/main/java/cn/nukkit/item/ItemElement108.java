package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement108 extends Item {

    public ItemElement108() {
        this(0, 1);
    }

    public ItemElement108(Integer meta) {
        this(meta, 1);
    }

    public ItemElement108(Integer meta, int count) {
        super(ItemID.ELEMENT_108, meta, count, "Element 108");
        this.block = Block.get(BlockID.ELEMENT_108, meta);
    }
}