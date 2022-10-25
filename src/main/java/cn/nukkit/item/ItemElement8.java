package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement8 extends Item {

    public ItemElement8() {
        this(0, 1);
    }

    public ItemElement8(Integer meta) {
        this(meta, 1);
    }

    public ItemElement8(Integer meta, int count) {
        super(ItemID.ELEMENT_8, meta, count, "Element 8");
        this.block = Block.get(BlockID.ELEMENT_8, meta);
    }
}