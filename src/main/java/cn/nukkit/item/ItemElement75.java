package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement75 extends Item {

    public ItemElement75() {
        this(0, 1);
    }

    public ItemElement75(Integer meta) {
        this(meta, 1);
    }

    public ItemElement75(Integer meta, int count) {
        super(ItemID.ELEMENT_75, meta, count, "Element 75");
        this.block = Block.get(BlockID.ELEMENT_75, meta);
    }
}