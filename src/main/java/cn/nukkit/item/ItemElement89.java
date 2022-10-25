package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement89 extends Item {

    public ItemElement89() {
        this(0, 1);
    }

    public ItemElement89(Integer meta) {
        this(meta, 1);
    }

    public ItemElement89(Integer meta, int count) {
        super(ItemID.ELEMENT_89, meta, count, "Element 89");
        this.block = Block.get(BlockID.ELEMENT_89, meta);
    }
}