package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement47 extends Item {

    public ItemElement47() {
        this(0, 1);
    }

    public ItemElement47(Integer meta) {
        this(meta, 1);
    }

    public ItemElement47(Integer meta, int count) {
        super(ItemID.ELEMENT_47, meta, count, "Element 47");
        this.block = Block.get(BlockID.ELEMENT_47, meta);
    }
}