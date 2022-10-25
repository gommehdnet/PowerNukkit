package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement71 extends Item {

    public ItemElement71() {
        this(0, 1);
    }

    public ItemElement71(Integer meta) {
        this(meta, 1);
    }

    public ItemElement71(Integer meta, int count) {
        super(ItemID.ELEMENT_71, meta, count, "Element 71");
        this.block = Block.get(BlockID.ELEMENT_71, meta);
    }
}