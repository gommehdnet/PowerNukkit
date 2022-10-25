package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement2 extends Item {

    public ItemElement2() {
        this(0, 1);
    }

    public ItemElement2(Integer meta) {
        this(meta, 1);
    }

    public ItemElement2(Integer meta, int count) {
        super(ItemID.ELEMENT_2, meta, count, "Element 2");
        this.block = Block.get(BlockID.ELEMENT_2, meta);
    }
}