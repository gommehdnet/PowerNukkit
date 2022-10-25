package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedCrimsonHyphae extends Item {

    public ItemStrippedCrimsonHyphae() {
        this(0, 1);
    }

    public ItemStrippedCrimsonHyphae(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedCrimsonHyphae(Integer meta, int count) {
        super(ItemID.STRIPPED_CRIMSON_HYPHAE, meta, count, "Stripped Crimson Hyphae");
        this.block = Block.get(BlockID.STRIPPED_CRIMSON_HYPHAE, meta);
    }
}