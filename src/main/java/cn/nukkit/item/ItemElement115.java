package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement115 extends Item {

    public ItemElement115() {
        this(0, 1);
    }

    public ItemElement115(Integer meta) {
        this(meta, 1);
    }

    public ItemElement115(Integer meta, int count) {
        super(ItemID.ELEMENT_115, meta, count, "Element 115");
        this.block = Block.get(BlockID.ELEMENT_115, meta);
    }
}