package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement44 extends Item {

    public ItemElement44() {
        this(0, 1);
    }

    public ItemElement44(Integer meta) {
        this(meta, 1);
    }

    public ItemElement44(Integer meta, int count) {
        super(ItemID.ELEMENT_44, meta, count, "Element 44");
        this.block = Block.get(BlockID.ELEMENT_44, meta);
    }
}