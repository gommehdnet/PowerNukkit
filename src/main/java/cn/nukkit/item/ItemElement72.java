package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement72 extends Item {

    public ItemElement72() {
        this(0, 1);
    }

    public ItemElement72(Integer meta) {
        this(meta, 1);
    }

    public ItemElement72(Integer meta, int count) {
        super(ItemID.ELEMENT_72, meta, count, "Element 72");
        this.block = Block.get(BlockID.ELEMENT_72, meta);
    }
}