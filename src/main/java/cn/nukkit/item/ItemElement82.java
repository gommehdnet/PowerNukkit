package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement82 extends Item {

    public ItemElement82() {
        this(0, 1);
    }

    public ItemElement82(Integer meta) {
        this(meta, 1);
    }

    public ItemElement82(Integer meta, int count) {
        super(ItemID.ELEMENT_82, meta, count, "Element 82");
        this.block = Block.get(BlockID.ELEMENT_82, meta);
    }
}