package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement86 extends Item {

    public ItemElement86() {
        this(0, 1);
    }

    public ItemElement86(Integer meta) {
        this(meta, 1);
    }

    public ItemElement86(Integer meta, int count) {
        super(ItemID.ELEMENT_86, meta, count, "Element 86");
        this.block = Block.get(BlockID.ELEMENT_86, meta);
    }
}