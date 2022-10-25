package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement50 extends Item {

    public ItemElement50() {
        this(0, 1);
    }

    public ItemElement50(Integer meta) {
        this(meta, 1);
    }

    public ItemElement50(Integer meta, int count) {
        super(ItemID.ELEMENT_50, meta, count, "Element 50");
        this.block = Block.get(BlockID.ELEMENT_50, meta);
    }
}