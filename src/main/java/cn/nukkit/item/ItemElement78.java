package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement78 extends Item {

    public ItemElement78() {
        this(0, 1);
    }

    public ItemElement78(Integer meta) {
        this(meta, 1);
    }

    public ItemElement78(Integer meta, int count) {
        super(ItemID.ELEMENT_78, meta, count, "Element 78");
        this.block = Block.get(BlockID.ELEMENT_78, meta);
    }
}