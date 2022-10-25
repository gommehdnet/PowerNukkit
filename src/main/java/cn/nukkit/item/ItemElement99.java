package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement99 extends Item {

    public ItemElement99() {
        this(0, 1);
    }

    public ItemElement99(Integer meta) {
        this(meta, 1);
    }

    public ItemElement99(Integer meta, int count) {
        super(ItemID.ELEMENT_99, meta, count, "Element 99");
        this.block = Block.get(BlockID.ELEMENT_99, meta);
    }
}