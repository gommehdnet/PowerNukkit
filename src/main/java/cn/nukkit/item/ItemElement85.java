package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement85 extends Item {

    public ItemElement85() {
        this(0, 1);
    }

    public ItemElement85(Integer meta) {
        this(meta, 1);
    }

    public ItemElement85(Integer meta, int count) {
        super(ItemID.ELEMENT_85, meta, count, "Element 85");
        this.block = Block.get(BlockID.ELEMENT_85, meta);
    }
}