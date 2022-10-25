package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement56 extends Item {

    public ItemElement56() {
        this(0, 1);
    }

    public ItemElement56(Integer meta) {
        this(meta, 1);
    }

    public ItemElement56(Integer meta, int count) {
        super(ItemID.ELEMENT_56, meta, count, "Element 56");
        this.block = Block.get(BlockID.ELEMENT_56, meta);
    }
}