package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement104 extends Item {

    public ItemElement104() {
        this(0, 1);
    }

    public ItemElement104(Integer meta) {
        this(meta, 1);
    }

    public ItemElement104(Integer meta, int count) {
        super(ItemID.ELEMENT_104, meta, count, "Element 104");
        this.block = Block.get(BlockID.ELEMENT_104, meta);
    }
}