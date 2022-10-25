package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement88 extends Item {

    public ItemElement88() {
        this(0, 1);
    }

    public ItemElement88(Integer meta) {
        this(meta, 1);
    }

    public ItemElement88(Integer meta, int count) {
        super(ItemID.ELEMENT_88, meta, count, "Element 88");
        this.block = Block.get(BlockID.ELEMENT_88, meta);
    }
}