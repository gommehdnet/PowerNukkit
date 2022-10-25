package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement87 extends Item {

    public ItemElement87() {
        this(0, 1);
    }

    public ItemElement87(Integer meta) {
        this(meta, 1);
    }

    public ItemElement87(Integer meta, int count) {
        super(ItemID.ELEMENT_87, meta, count, "Element 87");
        this.block = Block.get(BlockID.ELEMENT_87, meta);
    }
}