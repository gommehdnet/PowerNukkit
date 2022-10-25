package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJungleTrapdoor extends Item {

    public ItemJungleTrapdoor() {
        this(0, 1);
    }

    public ItemJungleTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemJungleTrapdoor(Integer meta, int count) {
        super(ItemID.JUNGLE_TRAPDOOR, meta, count, "Jungle Trapdoor");
        this.block = Block.get(BlockID.JUNGLE_TRAPDOOR, meta);
    }
}