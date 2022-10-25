package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement64 extends Item {

    public ItemElement64() {
        this(0, 1);
    }

    public ItemElement64(Integer meta) {
        this(meta, 1);
    }

    public ItemElement64(Integer meta, int count) {
        super(ItemID.ELEMENT_64, meta, count, "Element 64");
        this.block = Block.get(BlockID.ELEMENT_64, meta);
    }
}