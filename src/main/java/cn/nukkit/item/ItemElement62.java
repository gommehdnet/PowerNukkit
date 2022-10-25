package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement62 extends Item {

    public ItemElement62() {
        this(0, 1);
    }

    public ItemElement62(Integer meta) {
        this(meta, 1);
    }

    public ItemElement62(Integer meta, int count) {
        super(ItemID.ELEMENT_62, meta, count, "Element 62");
        this.block = Block.get(BlockID.ELEMENT_62, meta);
    }
}