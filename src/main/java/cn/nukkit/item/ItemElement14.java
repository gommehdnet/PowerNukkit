package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement14 extends Item {

    public ItemElement14() {
        this(0, 1);
    }

    public ItemElement14(Integer meta) {
        this(meta, 1);
    }

    public ItemElement14(Integer meta, int count) {
        super(ItemID.ELEMENT_14, meta, count, "Element 14");
        this.block = Block.get(BlockID.ELEMENT_14, meta);
    }
}