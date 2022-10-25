package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement101 extends Item {

    public ItemElement101() {
        this(0, 1);
    }

    public ItemElement101(Integer meta) {
        this(meta, 1);
    }

    public ItemElement101(Integer meta, int count) {
        super(ItemID.ELEMENT_101, meta, count, "Element 101");
        this.block = Block.get(BlockID.ELEMENT_101, meta);
    }
}