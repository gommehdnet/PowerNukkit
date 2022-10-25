package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonFungus extends Item {

    public ItemCrimsonFungus() {
        this(0, 1);
    }

    public ItemCrimsonFungus(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonFungus(Integer meta, int count) {
        super(ItemID.CRIMSON_FUNGUS, meta, count, "Crimson Fungus");
        this.block = Block.get(BlockID.CRIMSON_FUNGUS, meta);
    }
}