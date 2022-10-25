package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonHyphae extends Item {

    public ItemCrimsonHyphae() {
        this(0, 1);
    }

    public ItemCrimsonHyphae(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonHyphae(Integer meta, int count) {
        super(ItemID.CRIMSON_HYPHAE, meta, count, "Crimson Hyphae");
        this.block = Block.get(BlockID.CRIMSON_HYPHAE, meta);
    }
}