package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement32 extends Item {

    public ItemElement32() {
        this(0, 1);
    }

    public ItemElement32(Integer meta) {
        this(meta, 1);
    }

    public ItemElement32(Integer meta, int count) {
        super(ItemID.ELEMENT_32, meta, count, "Element 32");
        this.block = Block.get(BlockID.ELEMENT_32, meta);
    }
}