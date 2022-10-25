package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement111 extends Item {

    public ItemElement111() {
        this(0, 1);
    }

    public ItemElement111(Integer meta) {
        this(meta, 1);
    }

    public ItemElement111(Integer meta, int count) {
        super(ItemID.ELEMENT_111, meta, count, "Element 111");
        this.block = Block.get(BlockID.ELEMENT_111, meta);
    }
}