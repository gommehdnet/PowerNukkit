package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement18 extends Item {

    public ItemElement18() {
        this(0, 1);
    }

    public ItemElement18(Integer meta) {
        this(meta, 1);
    }

    public ItemElement18(Integer meta, int count) {
        super(ItemID.ELEMENT_18, meta, count, "Element 18");
        this.block = Block.get(BlockID.ELEMENT_18, meta);
    }
}