package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement13 extends Item {

    public ItemElement13() {
        this(0, 1);
    }

    public ItemElement13(Integer meta) {
        this(meta, 1);
    }

    public ItemElement13(Integer meta, int count) {
        super(ItemID.ELEMENT_13, meta, count, "Element 13");
        this.block = Block.get(BlockID.ELEMENT_13, meta);
    }
}