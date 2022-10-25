package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement117 extends Item {

    public ItemElement117() {
        this(0, 1);
    }

    public ItemElement117(Integer meta) {
        this(meta, 1);
    }

    public ItemElement117(Integer meta, int count) {
        super(ItemID.ELEMENT_117, meta, count, "Element 117");
        this.block = Block.get(BlockID.ELEMENT_117, meta);
    }
}