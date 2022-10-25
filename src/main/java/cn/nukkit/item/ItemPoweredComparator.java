package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPoweredComparator extends Item {

    public ItemPoweredComparator() {
        this(0, 1);
    }

    public ItemPoweredComparator(Integer meta) {
        this(meta, 1);
    }

    public ItemPoweredComparator(Integer meta, int count) {
        super(ItemID.POWERED_COMPARATOR, meta, count, "Powered Comparator");
        this.block = Block.get(BlockID.POWERED_COMPARATOR, meta);
    }
}