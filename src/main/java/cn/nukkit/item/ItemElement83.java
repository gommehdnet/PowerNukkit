package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement83 extends Item {

    public ItemElement83() {
        this(0, 1);
    }

    public ItemElement83(Integer meta) {
        this(meta, 1);
    }

    public ItemElement83(Integer meta, int count) {
        super(ItemID.ELEMENT_83, meta, count, "Element 83");
        this.block = Block.get(BlockID.ELEMENT_83, meta);
    }
}