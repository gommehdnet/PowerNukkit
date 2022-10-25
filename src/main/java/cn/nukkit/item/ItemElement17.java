package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement17 extends Item {

    public ItemElement17() {
        this(0, 1);
    }

    public ItemElement17(Integer meta) {
        this(meta, 1);
    }

    public ItemElement17(Integer meta, int count) {
        super(ItemID.ELEMENT_17, meta, count, "Element 17");
        this.block = Block.get(BlockID.ELEMENT_17, meta);
    }
}