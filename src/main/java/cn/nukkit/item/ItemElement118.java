package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement118 extends Item {

    public ItemElement118() {
        this(0, 1);
    }

    public ItemElement118(Integer meta) {
        this(meta, 1);
    }

    public ItemElement118(Integer meta, int count) {
        super(ItemID.ELEMENT_118, meta, count, "Element 118");
        this.block = Block.get(BlockID.ELEMENT_118, meta);
    }
}