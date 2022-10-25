package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement52 extends Item {

    public ItemElement52() {
        this(0, 1);
    }

    public ItemElement52(Integer meta) {
        this(meta, 1);
    }

    public ItemElement52(Integer meta, int count) {
        super(ItemID.ELEMENT_52, meta, count, "Element 52");
        this.block = Block.get(BlockID.ELEMENT_52, meta);
    }
}