package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement19 extends Item {

    public ItemElement19() {
        this(0, 1);
    }

    public ItemElement19(Integer meta) {
        this(meta, 1);
    }

    public ItemElement19(Integer meta, int count) {
        super(ItemID.ELEMENT_19, meta, count, "Element 19");
        this.block = Block.get(BlockID.ELEMENT_19, meta);
    }
}