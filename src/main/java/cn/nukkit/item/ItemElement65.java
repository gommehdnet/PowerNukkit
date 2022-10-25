package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement65 extends Item {

    public ItemElement65() {
        this(0, 1);
    }

    public ItemElement65(Integer meta) {
        this(meta, 1);
    }

    public ItemElement65(Integer meta, int count) {
        super(ItemID.ELEMENT_65, meta, count, "Element 65");
        this.block = Block.get(BlockID.ELEMENT_65, meta);
    }
}