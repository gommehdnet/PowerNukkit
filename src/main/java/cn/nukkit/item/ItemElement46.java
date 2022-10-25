package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement46 extends Item {

    public ItemElement46() {
        this(0, 1);
    }

    public ItemElement46(Integer meta) {
        this(meta, 1);
    }

    public ItemElement46(Integer meta, int count) {
        super(ItemID.ELEMENT_46, meta, count, "Element 46");
        this.block = Block.get(BlockID.ELEMENT_46, meta);
    }
}