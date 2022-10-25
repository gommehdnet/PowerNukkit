package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement106 extends Item {

    public ItemElement106() {
        this(0, 1);
    }

    public ItemElement106(Integer meta) {
        this(meta, 1);
    }

    public ItemElement106(Integer meta, int count) {
        super(ItemID.ELEMENT_106, meta, count, "Element 106");
        this.block = Block.get(BlockID.ELEMENT_106, meta);
    }
}