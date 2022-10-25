package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement103 extends Item {

    public ItemElement103() {
        this(0, 1);
    }

    public ItemElement103(Integer meta) {
        this(meta, 1);
    }

    public ItemElement103(Integer meta, int count) {
        super(ItemID.ELEMENT_103, meta, count, "Element 103");
        this.block = Block.get(BlockID.ELEMENT_103, meta);
    }
}