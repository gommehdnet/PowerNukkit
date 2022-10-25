package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement55 extends Item {

    public ItemElement55() {
        this(0, 1);
    }

    public ItemElement55(Integer meta) {
        this(meta, 1);
    }

    public ItemElement55(Integer meta, int count) {
        super(ItemID.ELEMENT_55, meta, count, "Element 55");
        this.block = Block.get(BlockID.ELEMENT_55, meta);
    }
}