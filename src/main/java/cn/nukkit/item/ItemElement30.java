package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement30 extends Item {

    public ItemElement30() {
        this(0, 1);
    }

    public ItemElement30(Integer meta) {
        this(meta, 1);
    }

    public ItemElement30(Integer meta, int count) {
        super(ItemID.ELEMENT_30, meta, count, "Element 30");
        this.block = Block.get(BlockID.ELEMENT_30, meta);
    }
}