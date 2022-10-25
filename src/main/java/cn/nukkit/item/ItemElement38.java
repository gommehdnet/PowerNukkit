package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElement38 extends Item {

    public ItemElement38() {
        this(0, 1);
    }

    public ItemElement38(Integer meta) {
        this(meta, 1);
    }

    public ItemElement38(Integer meta, int count) {
        super(ItemID.ELEMENT_38, meta, count, "Element 38");
        this.block = Block.get(BlockID.ELEMENT_38, meta);
    }
}