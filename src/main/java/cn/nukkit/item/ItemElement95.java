package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement95 extends Item {

    public ItemElement95() {
        this(0, 1);
    }

    public ItemElement95(Integer meta) {
        this(meta, 1);
    }

    public ItemElement95(Integer meta, int count) {
        super(ItemID.ELEMENT_95, meta, count, "Element 95");
        this.block = Block.get(BlockID.ELEMENT_95, meta);
    }
}