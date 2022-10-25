package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement49 extends Item {

    public ItemElement49() {
        this(0, 1);
    }

    public ItemElement49(Integer meta) {
        this(meta, 1);
    }

    public ItemElement49(Integer meta, int count) {
        super(ItemID.ELEMENT_49, meta, count, "Element 49");
        this.block = Block.get(BlockID.ELEMENT_49, meta);
    }
}