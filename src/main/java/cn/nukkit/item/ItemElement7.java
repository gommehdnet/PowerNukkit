package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement7 extends Item {

    public ItemElement7() {
        this(0, 1);
    }

    public ItemElement7(Integer meta) {
        this(meta, 1);
    }

    public ItemElement7(Integer meta, int count) {
        super(ItemID.ELEMENT_7, meta, count, "Element 7");
        this.block = Block.get(BlockID.ELEMENT_7, meta);
    }
}