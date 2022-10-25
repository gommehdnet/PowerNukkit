package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement40 extends Item {

    public ItemElement40() {
        this(0, 1);
    }

    public ItemElement40(Integer meta) {
        this(meta, 1);
    }

    public ItemElement40(Integer meta, int count) {
        super(ItemID.ELEMENT_40, meta, count, "Element 40");
        this.block = Block.get(BlockID.ELEMENT_40, meta);
    }
}