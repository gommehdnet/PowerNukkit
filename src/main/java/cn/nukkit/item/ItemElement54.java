package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement54 extends Item {

    public ItemElement54() {
        this(0, 1);
    }

    public ItemElement54(Integer meta) {
        this(meta, 1);
    }

    public ItemElement54(Integer meta, int count) {
        super(ItemID.ELEMENT_54, meta, count, "Element 54");
        this.block = Block.get(BlockID.ELEMENT_54, meta);
    }
}