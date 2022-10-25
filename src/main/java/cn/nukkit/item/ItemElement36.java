package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement36 extends Item {

    public ItemElement36() {
        this(0, 1);
    }

    public ItemElement36(Integer meta) {
        this(meta, 1);
    }

    public ItemElement36(Integer meta, int count) {
        super(ItemID.ELEMENT_36, meta, count, "Element 36");
        this.block = Block.get(BlockID.ELEMENT_36, meta);
    }
}