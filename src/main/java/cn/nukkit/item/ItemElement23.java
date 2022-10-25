package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement23 extends Item {

    public ItemElement23() {
        this(0, 1);
    }

    public ItemElement23(Integer meta) {
        this(meta, 1);
    }

    public ItemElement23(Integer meta, int count) {
        super(ItemID.ELEMENT_23, meta, count, "Element 23");
        this.block = Block.get(BlockID.ELEMENT_23, meta);
    }
}