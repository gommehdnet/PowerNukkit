package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemObsidian extends Item {

    public ItemObsidian() {
        this(0, 1);
    }

    public ItemObsidian(Integer meta) {
        this(meta, 1);
    }

    public ItemObsidian(Integer meta, int count) {
        super(ItemID.OBSIDIAN, meta, count, "Obsidian");
        this.block = Block.get(BlockID.OBSIDIAN, meta);
    }
}