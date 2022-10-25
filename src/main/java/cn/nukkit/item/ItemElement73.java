package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement73 extends Item {

    public ItemElement73() {
        this(0, 1);
    }

    public ItemElement73(Integer meta) {
        this(meta, 1);
    }

    public ItemElement73(Integer meta, int count) {
        super(ItemID.ELEMENT_73, meta, count, "Element 73");
        this.block = Block.get(BlockID.ELEMENT_73, meta);
    }
}