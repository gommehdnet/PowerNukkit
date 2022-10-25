package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement34 extends Item {

    public ItemElement34() {
        this(0, 1);
    }

    public ItemElement34(Integer meta) {
        this(meta, 1);
    }

    public ItemElement34(Integer meta, int count) {
        super(ItemID.ELEMENT_34, meta, count, "Element 34");
        this.block = Block.get(BlockID.ELEMENT_34, meta);
    }
}