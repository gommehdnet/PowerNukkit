package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement43 extends Item {

    public ItemElement43() {
        this(0, 1);
    }

    public ItemElement43(Integer meta) {
        this(meta, 1);
    }

    public ItemElement43(Integer meta, int count) {
        super(ItemID.ELEMENT_43, meta, count, "Element 43");
        this.block = Block.get(BlockID.ELEMENT_43, meta);
    }
}