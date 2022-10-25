package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWood extends Item {

    public ItemWood() {
        this(0, 1);
    }

    public ItemWood(Integer meta) {
        this(meta, 1);
    }

    public ItemWood(Integer meta, int count) {
        super(ItemID.WOOD, meta, count, "Wood");
        this.block = Block.get(BlockID.WOOD, meta);
    }
}