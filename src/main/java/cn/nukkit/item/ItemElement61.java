package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement61 extends Item {

    public ItemElement61() {
        this(0, 1);
    }

    public ItemElement61(Integer meta) {
        this(meta, 1);
    }

    public ItemElement61(Integer meta, int count) {
        super(ItemID.ELEMENT_61, meta, count, "Element 61");
        this.block = Block.get(BlockID.ELEMENT_61, meta);
    }
}