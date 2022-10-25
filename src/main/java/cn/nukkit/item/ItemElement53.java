package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement53 extends Item {

    public ItemElement53() {
        this(0, 1);
    }

    public ItemElement53(Integer meta) {
        this(meta, 1);
    }

    public ItemElement53(Integer meta, int count) {
        super(ItemID.ELEMENT_53, meta, count, "Element 53");
        this.block = Block.get(BlockID.ELEMENT_53, meta);
    }
}