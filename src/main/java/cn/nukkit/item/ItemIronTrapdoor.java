package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemIronTrapdoor extends Item {

    public ItemIronTrapdoor() {
        this(0, 1);
    }

    public ItemIronTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemIronTrapdoor(Integer meta, int count) {
        super(ItemID.IRON_TRAPDOOR, meta, count, "Iron Trapdoor");
        this.block = Block.get(BlockID.IRON_TRAPDOOR, meta);
    }
}