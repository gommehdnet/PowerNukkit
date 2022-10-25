package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement37 extends Item {

    public ItemElement37() {
        this(0, 1);
    }

    public ItemElement37(Integer meta) {
        this(meta, 1);
    }

    public ItemElement37(Integer meta, int count) {
        super(ItemID.ELEMENT_37, meta, count, "Element 37");
        this.block = Block.get(BlockID.ELEMENT_37, meta);
    }
}