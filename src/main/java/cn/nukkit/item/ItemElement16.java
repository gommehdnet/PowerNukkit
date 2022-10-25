package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement16 extends Item {

    public ItemElement16() {
        this(0, 1);
    }

    public ItemElement16(Integer meta) {
        this(meta, 1);
    }

    public ItemElement16(Integer meta, int count) {
        super(ItemID.ELEMENT_16, meta, count, "Element 16");
        this.block = Block.get(BlockID.ELEMENT_16, meta);
    }
}