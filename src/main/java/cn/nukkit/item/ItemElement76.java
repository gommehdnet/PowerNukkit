package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement76 extends Item {

    public ItemElement76() {
        this(0, 1);
    }

    public ItemElement76(Integer meta) {
        this(meta, 1);
    }

    public ItemElement76(Integer meta, int count) {
        super(ItemID.ELEMENT_76, meta, count, "Element 76");
        this.block = Block.get(BlockID.ELEMENT_76, meta);
    }
}