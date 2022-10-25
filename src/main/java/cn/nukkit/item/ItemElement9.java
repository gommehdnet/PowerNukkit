package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement9 extends Item {

    public ItemElement9() {
        this(0, 1);
    }

    public ItemElement9(Integer meta) {
        this(meta, 1);
    }

    public ItemElement9(Integer meta, int count) {
        super(ItemID.ELEMENT_9, meta, count, "Element 9");
        this.block = Block.get(BlockID.ELEMENT_9, meta);
    }
}