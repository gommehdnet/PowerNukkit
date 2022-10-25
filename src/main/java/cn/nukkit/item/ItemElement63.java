package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement63 extends Item {

    public ItemElement63() {
        this(0, 1);
    }

    public ItemElement63(Integer meta) {
        this(meta, 1);
    }

    public ItemElement63(Integer meta, int count) {
        super(ItemID.ELEMENT_63, meta, count, "Element 63");
        this.block = Block.get(BlockID.ELEMENT_63, meta);
    }
}