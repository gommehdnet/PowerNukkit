package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement51 extends Item {

    public ItemElement51() {
        this(0, 1);
    }

    public ItemElement51(Integer meta) {
        this(meta, 1);
    }

    public ItemElement51(Integer meta, int count) {
        super(ItemID.ELEMENT_51, meta, count, "Element 51");
        this.block = Block.get(BlockID.ELEMENT_51, meta);
    }
}