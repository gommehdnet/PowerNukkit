package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement112 extends Item {

    public ItemElement112() {
        this(0, 1);
    }

    public ItemElement112(Integer meta) {
        this(meta, 1);
    }

    public ItemElement112(Integer meta, int count) {
        super(ItemID.ELEMENT_112, meta, count, "Element 112");
        this.block = Block.get(BlockID.ELEMENT_112, meta);
    }
}