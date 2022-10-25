package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement113 extends Item {

    public ItemElement113() {
        this(0, 1);
    }

    public ItemElement113(Integer meta) {
        this(meta, 1);
    }

    public ItemElement113(Integer meta, int count) {
        super(ItemID.ELEMENT_113, meta, count, "Element 113");
        this.block = Block.get(BlockID.ELEMENT_113, meta);
    }
}