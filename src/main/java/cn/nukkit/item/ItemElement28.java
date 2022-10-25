package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement28 extends Item {

    public ItemElement28() {
        this(0, 1);
    }

    public ItemElement28(Integer meta) {
        this(meta, 1);
    }

    public ItemElement28(Integer meta, int count) {
        super(ItemID.ELEMENT_28, meta, count, "Element 28");
        this.block = Block.get(BlockID.ELEMENT_28, meta);
    }
}