package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement92 extends Item {

    public ItemElement92() {
        this(0, 1);
    }

    public ItemElement92(Integer meta) {
        this(meta, 1);
    }

    public ItemElement92(Integer meta, int count) {
        super(ItemID.ELEMENT_92, meta, count, "Element 92");
        this.block = Block.get(BlockID.ELEMENT_92, meta);
    }
}