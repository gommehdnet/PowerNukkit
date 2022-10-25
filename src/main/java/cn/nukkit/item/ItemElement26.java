package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement26 extends Item {

    public ItemElement26() {
        this(0, 1);
    }

    public ItemElement26(Integer meta) {
        this(meta, 1);
    }

    public ItemElement26(Integer meta, int count) {
        super(ItemID.ELEMENT_26, meta, count, "Element 26");
        this.block = Block.get(BlockID.ELEMENT_26, meta);
    }
}