package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement114 extends Item {

    public ItemElement114() {
        this(0, 1);
    }

    public ItemElement114(Integer meta) {
        this(meta, 1);
    }

    public ItemElement114(Integer meta, int count) {
        super(ItemID.ELEMENT_114, meta, count, "Element 114");
        this.block = Block.get(BlockID.ELEMENT_114, meta);
    }
}