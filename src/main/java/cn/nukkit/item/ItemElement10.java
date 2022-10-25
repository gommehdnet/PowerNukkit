package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement10 extends Item {

    public ItemElement10() {
        this(0, 1);
    }

    public ItemElement10(Integer meta) {
        this(meta, 1);
    }

    public ItemElement10(Integer meta, int count) {
        super(ItemID.ELEMENT_10, meta, count, "Element 10");
        this.block = Block.get(BlockID.ELEMENT_10, meta);
    }
}