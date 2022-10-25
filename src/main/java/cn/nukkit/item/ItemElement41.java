package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement41 extends Item {

    public ItemElement41() {
        this(0, 1);
    }

    public ItemElement41(Integer meta) {
        this(meta, 1);
    }

    public ItemElement41(Integer meta, int count) {
        super(ItemID.ELEMENT_41, meta, count, "Element 41");
        this.block = Block.get(BlockID.ELEMENT_41, meta);
    }
}