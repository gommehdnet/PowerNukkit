package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement107 extends Item {

    public ItemElement107() {
        this(0, 1);
    }

    public ItemElement107(Integer meta) {
        this(meta, 1);
    }

    public ItemElement107(Integer meta, int count) {
        super(ItemID.ELEMENT_107, meta, count, "Element 107");
        this.block = Block.get(BlockID.ELEMENT_107, meta);
    }
}