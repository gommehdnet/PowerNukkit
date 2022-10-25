package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement24 extends Item {

    public ItemElement24() {
        this(0, 1);
    }

    public ItemElement24(Integer meta) {
        this(meta, 1);
    }

    public ItemElement24(Integer meta, int count) {
        super(ItemID.ELEMENT_24, meta, count, "Element 24");
        this.block = Block.get(BlockID.ELEMENT_24, meta);
    }
}