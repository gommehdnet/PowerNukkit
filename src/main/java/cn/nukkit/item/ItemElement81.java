package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement81 extends Item {

    public ItemElement81() {
        this(0, 1);
    }

    public ItemElement81(Integer meta) {
        this(meta, 1);
    }

    public ItemElement81(Integer meta, int count) {
        super(ItemID.ELEMENT_81, meta, count, "Element 81");
        this.block = Block.get(BlockID.ELEMENT_81, meta);
    }
}