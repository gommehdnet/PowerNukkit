package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemUnpoweredComparator extends Item {

    public ItemUnpoweredComparator() {
        this(0, 1);
    }

    public ItemUnpoweredComparator(Integer meta) {
        this(meta, 1);
    }

    public ItemUnpoweredComparator(Integer meta, int count) {
        super(ItemID.UNPOWERED_COMPARATOR, meta, count, "Unpowered Comparator");
        this.block = Block.get(BlockID.UNPOWERED_COMPARATOR, meta);
    }
}