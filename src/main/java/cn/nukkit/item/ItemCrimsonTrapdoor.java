package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonTrapdoor extends Item {

    public ItemCrimsonTrapdoor() {
        this(0, 1);
    }

    public ItemCrimsonTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonTrapdoor(Integer meta, int count) {
        super(ItemID.CRIMSON_TRAPDOOR, meta, count, "Crimson Trapdoor");
        this.block = Block.get(BlockID.CRIMSON_TRAPDOOR, meta);
    }
}