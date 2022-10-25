package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement97 extends Item {

    public ItemElement97() {
        this(0, 1);
    }

    public ItemElement97(Integer meta) {
        this(meta, 1);
    }

    public ItemElement97(Integer meta, int count) {
        super(ItemID.ELEMENT_97, meta, count, "Element 97");
        this.block = Block.get(BlockID.ELEMENT_97, meta);
    }
}