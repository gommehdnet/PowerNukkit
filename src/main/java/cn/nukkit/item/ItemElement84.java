package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement84 extends Item {

    public ItemElement84() {
        this(0, 1);
    }

    public ItemElement84(Integer meta) {
        this(meta, 1);
    }

    public ItemElement84(Integer meta, int count) {
        super(ItemID.ELEMENT_84, meta, count, "Element 84");
        this.block = Block.get(BlockID.ELEMENT_84, meta);
    }
}