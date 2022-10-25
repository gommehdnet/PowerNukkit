package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement102 extends Item {

    public ItemElement102() {
        this(0, 1);
    }

    public ItemElement102(Integer meta) {
        this(meta, 1);
    }

    public ItemElement102(Integer meta, int count) {
        super(ItemID.ELEMENT_102, meta, count, "Element 102");
        this.block = Block.get(BlockID.ELEMENT_102, meta);
    }
}