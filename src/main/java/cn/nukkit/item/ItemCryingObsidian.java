package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCryingObsidian extends Item {

    public ItemCryingObsidian() {
        this(0, 1);
    }

    public ItemCryingObsidian(Integer meta) {
        this(meta, 1);
    }

    public ItemCryingObsidian(Integer meta, int count) {
        super(ItemID.CRYING_OBSIDIAN, meta, count, "Crying Obsidian");
        this.block = Block.get(BlockID.CRYING_OBSIDIAN, meta);
    }
}