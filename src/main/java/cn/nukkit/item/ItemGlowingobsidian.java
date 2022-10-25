package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlowingobsidian extends Item {

    public ItemGlowingobsidian() {
        this(0, 1);
    }

    public ItemGlowingobsidian(Integer meta) {
        this(meta, 1);
    }

    public ItemGlowingobsidian(Integer meta, int count) {
        super(ItemID.GLOWINGOBSIDIAN, meta, count, "Glowingobsidian");
        this.block = Block.get(BlockID.GLOWINGOBSIDIAN, meta);
    }
}