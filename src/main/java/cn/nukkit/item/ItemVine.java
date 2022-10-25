package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemVine extends Item {

    public ItemVine() {
        this(0, 1);
    }

    public ItemVine(Integer meta) {
        this(meta, 1);
    }

    public ItemVine(Integer meta, int count) {
        super(ItemID.VINE, meta, count, "Vine");
        this.block = Block.get(BlockID.VINE, meta);
    }
}