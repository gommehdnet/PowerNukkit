package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement31 extends Item {

    public ItemElement31() {
        this(0, 1);
    }

    public ItemElement31(Integer meta) {
        this(meta, 1);
    }

    public ItemElement31(Integer meta, int count) {
        super(ItemID.ELEMENT_31, meta, count, "Element 31");
        this.block = Block.get(BlockID.ELEMENT_31, meta);
    }
}