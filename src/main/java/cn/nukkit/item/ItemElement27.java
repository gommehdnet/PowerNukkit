package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement27 extends Item {

    public ItemElement27() {
        this(0, 1);
    }

    public ItemElement27(Integer meta) {
        this(meta, 1);
    }

    public ItemElement27(Integer meta, int count) {
        super(ItemID.ELEMENT_27, meta, count, "Element 27");
        this.block = Block.get(BlockID.ELEMENT_27, meta);
    }
}