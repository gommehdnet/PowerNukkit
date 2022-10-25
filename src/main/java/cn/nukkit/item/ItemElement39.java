package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement39 extends Item {

    public ItemElement39() {
        this(0, 1);
    }

    public ItemElement39(Integer meta) {
        this(meta, 1);
    }

    public ItemElement39(Integer meta, int count) {
        super(ItemID.ELEMENT_39, meta, count, "Element 39");
        this.block = Block.get(BlockID.ELEMENT_39, meta);
    }
}