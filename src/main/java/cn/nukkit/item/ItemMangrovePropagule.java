package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangrovePropagule extends Item {

    public ItemMangrovePropagule() {
        this(0, 1);
    }

    public ItemMangrovePropagule(Integer meta) {
        this(meta, 1);
    }

    public ItemMangrovePropagule(Integer meta, int count) {
        super(ItemID.MANGROVE_PROPAGULE, meta, count, "Mangrove Propagule");
        this.block = Block.get(BlockID.MANGROVE_PROPAGULE, meta);
    }
}