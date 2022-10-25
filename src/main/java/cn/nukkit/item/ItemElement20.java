package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement20 extends Item {

    public ItemElement20() {
        this(0, 1);
    }

    public ItemElement20(Integer meta) {
        this(meta, 1);
    }

    public ItemElement20(Integer meta, int count) {
        super(ItemID.ELEMENT_20, meta, count, "Element 20");
        this.block = Block.get(BlockID.ELEMENT_20, meta);
    }
}