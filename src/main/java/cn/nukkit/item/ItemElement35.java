package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement35 extends Item {

    public ItemElement35() {
        this(0, 1);
    }

    public ItemElement35(Integer meta) {
        this(meta, 1);
    }

    public ItemElement35(Integer meta, int count) {
        super(ItemID.ELEMENT_35, meta, count, "Element 35");
        this.block = Block.get(BlockID.ELEMENT_35, meta);
    }
}