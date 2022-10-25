package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement116 extends Item {

    public ItemElement116() {
        this(0, 1);
    }

    public ItemElement116(Integer meta) {
        this(meta, 1);
    }

    public ItemElement116(Integer meta, int count) {
        super(ItemID.ELEMENT_116, meta, count, "Element 116");
        this.block = Block.get(BlockID.ELEMENT_116, meta);
    }
}