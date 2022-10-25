package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement59 extends Item {

    public ItemElement59() {
        this(0, 1);
    }

    public ItemElement59(Integer meta) {
        this(meta, 1);
    }

    public ItemElement59(Integer meta, int count) {
        super(ItemID.ELEMENT_59, meta, count, "Element 59");
        this.block = Block.get(BlockID.ELEMENT_59, meta);
    }
}