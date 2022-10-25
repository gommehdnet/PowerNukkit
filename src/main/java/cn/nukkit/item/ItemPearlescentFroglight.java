package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPearlescentFroglight extends Item {

    public ItemPearlescentFroglight() {
        this(0, 1);
    }

    public ItemPearlescentFroglight(Integer meta) {
        this(meta, 1);
    }

    public ItemPearlescentFroglight(Integer meta, int count) {
        super(ItemID.PEARLESCENT_FROGLIGHT, meta, count, "Pearlescent Froglight");
        this.block = Block.get(BlockID.PEARLESCENT_FROGLIGHT, meta);
    }
}