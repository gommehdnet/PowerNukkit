package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlowstone extends Item {

    public ItemGlowstone() {
        this(0, 1);
    }

    public ItemGlowstone(Integer meta) {
        this(meta, 1);
    }

    public ItemGlowstone(Integer meta, int count) {
        super(ItemID.GLOWSTONE, meta, count, "Glowstone");
        this.block = Block.get(BlockID.GLOWSTONE, meta);
    }
}