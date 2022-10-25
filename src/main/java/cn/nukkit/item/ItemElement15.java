package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement15 extends Item {

    public ItemElement15() {
        this(0, 1);
    }

    public ItemElement15(Integer meta) {
        this(meta, 1);
    }

    public ItemElement15(Integer meta, int count) {
        super(ItemID.ELEMENT_15, meta, count, "Element 15");
        this.block = Block.get(BlockID.ELEMENT_15, meta);
    }
}