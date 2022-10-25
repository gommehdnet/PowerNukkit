package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement0 extends Item {

    public ItemElement0() {
        this(0, 1);
    }

    public ItemElement0(Integer meta) {
        this(meta, 1);
    }

    public ItemElement0(Integer meta, int count) {
        super(ItemID.ELEMENT_0, meta, count, "Element 0");
        this.block = Block.get(BlockID.ELEMENT_0, meta);
    }
}