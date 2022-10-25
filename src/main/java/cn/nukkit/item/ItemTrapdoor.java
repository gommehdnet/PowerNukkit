package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTrapdoor extends Item {

    public ItemTrapdoor() {
        this(0, 1);
    }

    public ItemTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemTrapdoor(Integer meta, int count) {
        super(ItemID.TRAPDOOR, meta, count, "Trapdoor");
        this.block = Block.get(BlockID.TRAPDOOR, meta);
    }
}