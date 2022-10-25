package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement110 extends Item {

    public ItemElement110() {
        this(0, 1);
    }

    public ItemElement110(Integer meta) {
        this(meta, 1);
    }

    public ItemElement110(Integer meta, int count) {
        super(ItemID.ELEMENT_110, meta, count, "Element 110");
        this.block = Block.get(BlockID.ELEMENT_110, meta);
    }
}