package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement4 extends Item {

    public ItemElement4() {
        this(0, 1);
    }

    public ItemElement4(Integer meta) {
        this(meta, 1);
    }

    public ItemElement4(Integer meta, int count) {
        super(ItemID.ELEMENT_4, meta, count, "Element 4");
        this.block = Block.get(BlockID.ELEMENT_4, meta);
    }
}