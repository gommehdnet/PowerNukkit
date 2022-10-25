package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement66 extends Item {

    public ItemElement66() {
        this(0, 1);
    }

    public ItemElement66(Integer meta) {
        this(meta, 1);
    }

    public ItemElement66(Integer meta, int count) {
        super(ItemID.ELEMENT_66, meta, count, "Element 66");
        this.block = Block.get(BlockID.ELEMENT_66, meta);
    }
}