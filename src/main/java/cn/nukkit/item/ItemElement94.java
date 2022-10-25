package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement94 extends Item {

    public ItemElement94() {
        this(0, 1);
    }

    public ItemElement94(Integer meta) {
        this(meta, 1);
    }

    public ItemElement94(Integer meta, int count) {
        super(ItemID.ELEMENT_94, meta, count, "Element 94");
        this.block = Block.get(BlockID.ELEMENT_94, meta);
    }
}