package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement79 extends Item {

    public ItemElement79() {
        this(0, 1);
    }

    public ItemElement79(Integer meta) {
        this(meta, 1);
    }

    public ItemElement79(Integer meta, int count) {
        super(ItemID.ELEMENT_79, meta, count, "Element 79");
        this.block = Block.get(BlockID.ELEMENT_79, meta);
    }
}