package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement60 extends Item {

    public ItemElement60() {
        this(0, 1);
    }

    public ItemElement60(Integer meta) {
        this(meta, 1);
    }

    public ItemElement60(Integer meta, int count) {
        super(ItemID.ELEMENT_60, meta, count, "Element 60");
        this.block = Block.get(BlockID.ELEMENT_60, meta);
    }
}