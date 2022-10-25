package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement3 extends Item {

    public ItemElement3() {
        this(0, 1);
    }

    public ItemElement3(Integer meta) {
        this(meta, 1);
    }

    public ItemElement3(Integer meta, int count) {
        super(ItemID.ELEMENT_3, meta, count, "Element 3");
        this.block = Block.get(BlockID.ELEMENT_3, meta);
    }
}