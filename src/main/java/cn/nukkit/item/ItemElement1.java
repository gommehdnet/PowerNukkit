package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement1 extends Item {

    public ItemElement1() {
        this(0, 1);
    }

    public ItemElement1(Integer meta) {
        this(meta, 1);
    }

    public ItemElement1(Integer meta, int count) {
        super(ItemID.ELEMENT_1, meta, count, "Element 1");
        this.block = Block.get(BlockID.ELEMENT_1, meta);
    }
}