package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement70 extends Item {

    public ItemElement70() {
        this(0, 1);
    }

    public ItemElement70(Integer meta) {
        this(meta, 1);
    }

    public ItemElement70(Integer meta, int count) {
        super(ItemID.ELEMENT_70, meta, count, "Element 70");
        this.block = Block.get(BlockID.ELEMENT_70, meta);
    }
}