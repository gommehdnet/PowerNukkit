package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement45 extends Item {

    public ItemElement45() {
        this(0, 1);
    }

    public ItemElement45(Integer meta) {
        this(meta, 1);
    }

    public ItemElement45(Integer meta, int count) {
        super(ItemID.ELEMENT_45, meta, count, "Element 45");
        this.block = Block.get(BlockID.ELEMENT_45, meta);
    }
}