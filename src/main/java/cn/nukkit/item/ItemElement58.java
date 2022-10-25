package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement58 extends Item {

    public ItemElement58() {
        this(0, 1);
    }

    public ItemElement58(Integer meta) {
        this(meta, 1);
    }

    public ItemElement58(Integer meta, int count) {
        super(ItemID.ELEMENT_58, meta, count, "Element 58");
        this.block = Block.get(BlockID.ELEMENT_58, meta);
    }
}