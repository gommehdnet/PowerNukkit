package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBirchTrapdoor extends Item {

    public ItemBirchTrapdoor() {
        this(0, 1);
    }

    public ItemBirchTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchTrapdoor(Integer meta, int count) {
        super(ItemID.BIRCH_TRAPDOOR, meta, count, "Birch Trapdoor");
        this.block = Block.get(BlockID.BIRCH_TRAPDOOR, meta);
    }
}