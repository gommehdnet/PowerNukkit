package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement29 extends Item {

    public ItemElement29() {
        this(0, 1);
    }

    public ItemElement29(Integer meta) {
        this(meta, 1);
    }

    public ItemElement29(Integer meta, int count) {
        super(ItemID.ELEMENT_29, meta, count, "Element 29");
        this.block = Block.get(BlockID.ELEMENT_29, meta);
    }
}