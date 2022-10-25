package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement74 extends Item {

    public ItemElement74() {
        this(0, 1);
    }

    public ItemElement74(Integer meta) {
        this(meta, 1);
    }

    public ItemElement74(Integer meta, int count) {
        super(ItemID.ELEMENT_74, meta, count, "Element 74");
        this.block = Block.get(BlockID.ELEMENT_74, meta);
    }
}