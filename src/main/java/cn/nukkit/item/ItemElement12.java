package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement12 extends Item {

    public ItemElement12() {
        this(0, 1);
    }

    public ItemElement12(Integer meta) {
        this(meta, 1);
    }

    public ItemElement12(Integer meta, int count) {
        super(ItemID.ELEMENT_12, meta, count, "Element 12");
        this.block = Block.get(BlockID.ELEMENT_12, meta);
    }
}