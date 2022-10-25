package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement67 extends Item {

    public ItemElement67() {
        this(0, 1);
    }

    public ItemElement67(Integer meta) {
        this(meta, 1);
    }

    public ItemElement67(Integer meta, int count) {
        super(ItemID.ELEMENT_67, meta, count, "Element 67");
        this.block = Block.get(BlockID.ELEMENT_67, meta);
    }
}