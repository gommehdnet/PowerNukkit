package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement98 extends Item {

    public ItemElement98() {
        this(0, 1);
    }

    public ItemElement98(Integer meta) {
        this(meta, 1);
    }

    public ItemElement98(Integer meta, int count) {
        super(ItemID.ELEMENT_98, meta, count, "Element 98");
        this.block = Block.get(BlockID.ELEMENT_98, meta);
    }
}