package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement25 extends Item {

    public ItemElement25() {
        this(0, 1);
    }

    public ItemElement25(Integer meta) {
        this(meta, 1);
    }

    public ItemElement25(Integer meta, int count) {
        super(ItemID.ELEMENT_25, meta, count, "Element 25");
        this.block = Block.get(BlockID.ELEMENT_25, meta);
    }
}