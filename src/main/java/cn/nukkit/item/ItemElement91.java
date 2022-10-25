package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement91 extends Item {

    public ItemElement91() {
        this(0, 1);
    }

    public ItemElement91(Integer meta) {
        this(meta, 1);
    }

    public ItemElement91(Integer meta, int count) {
        super(ItemID.ELEMENT_91, meta, count, "Element 91");
        this.block = Block.get(BlockID.ELEMENT_91, meta);
    }
}