package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement42 extends Item {

    public ItemElement42() {
        this(0, 1);
    }

    public ItemElement42(Integer meta) {
        this(meta, 1);
    }

    public ItemElement42(Integer meta, int count) {
        super(ItemID.ELEMENT_42, meta, count, "Element 42");
        this.block = Block.get(BlockID.ELEMENT_42, meta);
    }
}