package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement109 extends Item {

    public ItemElement109() {
        this(0, 1);
    }

    public ItemElement109(Integer meta) {
        this(meta, 1);
    }

    public ItemElement109(Integer meta, int count) {
        super(ItemID.ELEMENT_109, meta, count, "Element 109");
        this.block = Block.get(BlockID.ELEMENT_109, meta);
    }
}