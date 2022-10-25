package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement96 extends Item {

    public ItemElement96() {
        this(0, 1);
    }

    public ItemElement96(Integer meta) {
        this(meta, 1);
    }

    public ItemElement96(Integer meta, int count) {
        super(ItemID.ELEMENT_96, meta, count, "Element 96");
        this.block = Block.get(BlockID.ELEMENT_96, meta);
    }
}