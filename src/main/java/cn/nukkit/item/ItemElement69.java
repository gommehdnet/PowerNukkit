package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement69 extends Item {

    public ItemElement69() {
        this(0, 1);
    }

    public ItemElement69(Integer meta) {
        this(meta, 1);
    }

    public ItemElement69(Integer meta, int count) {
        super(ItemID.ELEMENT_69, meta, count, "Element 69");
        this.block = Block.get(BlockID.ELEMENT_69, meta);
    }
}