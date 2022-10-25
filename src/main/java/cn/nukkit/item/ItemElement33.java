package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement33 extends Item {

    public ItemElement33() {
        this(0, 1);
    }

    public ItemElement33(Integer meta) {
        this(meta, 1);
    }

    public ItemElement33(Integer meta, int count) {
        super(ItemID.ELEMENT_33, meta, count, "Element 33");
        this.block = Block.get(BlockID.ELEMENT_33, meta);
    }
}