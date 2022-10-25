package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement68 extends Item {

    public ItemElement68() {
        this(0, 1);
    }

    public ItemElement68(Integer meta) {
        this(meta, 1);
    }

    public ItemElement68(Integer meta, int count) {
        super(ItemID.ELEMENT_68, meta, count, "Element 68");
        this.block = Block.get(BlockID.ELEMENT_68, meta);
    }
}