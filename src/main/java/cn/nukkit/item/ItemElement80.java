package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement80 extends Item {

    public ItemElement80() {
        this(0, 1);
    }

    public ItemElement80(Integer meta) {
        this(meta, 1);
    }

    public ItemElement80(Integer meta, int count) {
        super(ItemID.ELEMENT_80, meta, count, "Element 80");
        this.block = Block.get(BlockID.ELEMENT_80, meta);
    }
}