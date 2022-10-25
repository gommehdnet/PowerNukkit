package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement100 extends Item {

    public ItemElement100() {
        this(0, 1);
    }

    public ItemElement100(Integer meta) {
        this(meta, 1);
    }

    public ItemElement100(Integer meta, int count) {
        super(ItemID.ELEMENT_100, meta, count, "Element 100");
        this.block = Block.get(BlockID.ELEMENT_100, meta);
    }
}