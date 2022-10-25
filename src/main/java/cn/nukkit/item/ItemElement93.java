package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement93 extends Item {

    public ItemElement93() {
        this(0, 1);
    }

    public ItemElement93(Integer meta) {
        this(meta, 1);
    }

    public ItemElement93(Integer meta, int count) {
        super(ItemID.ELEMENT_93, meta, count, "Element 93");
        this.block = Block.get(BlockID.ELEMENT_93, meta);
    }
}