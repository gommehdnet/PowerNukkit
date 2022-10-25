package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement77 extends Item {

    public ItemElement77() {
        this(0, 1);
    }

    public ItemElement77(Integer meta) {
        this(meta, 1);
    }

    public ItemElement77(Integer meta, int count) {
        super(ItemID.ELEMENT_77, meta, count, "Element 77");
        this.block = Block.get(BlockID.ELEMENT_77, meta);
    }
}