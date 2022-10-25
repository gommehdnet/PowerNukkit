package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement90 extends Item {

    public ItemElement90() {
        this(0, 1);
    }

    public ItemElement90(Integer meta) {
        this(meta, 1);
    }

    public ItemElement90(Integer meta, int count) {
        super(ItemID.ELEMENT_90, meta, count, "Element 90");
        this.block = Block.get(BlockID.ELEMENT_90, meta);
    }
}