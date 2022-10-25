package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author CreeperFace
 */
public class ItemComparator extends Item {

    public ItemComparator() {
        this(0);
    }

    public ItemComparator(Integer meta) {
        this(0, 1);
    }

    public ItemComparator(Integer meta, int count) {
        super(ItemID.COMPARATOR, meta, count, "Redstone Comparator");
        this.block = Block.get(BlockID.UNPOWERED_COMPARATOR);
    }
}