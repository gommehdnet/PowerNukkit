package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement5 extends Item {

    public ItemElement5() {
        this(0, 1);
    }

    public ItemElement5(Integer meta) {
        this(meta, 1);
    }

    public ItemElement5(Integer meta, int count) {
        super(ItemID.ELEMENT_5, meta, count, "Element 5");
        this.block = Block.get(BlockID.ELEMENT_5, meta);
    }
}