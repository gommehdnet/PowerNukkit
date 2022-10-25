package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveWood extends Item {

    public ItemMangroveWood() {
        this(0, 1);
    }

    public ItemMangroveWood(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveWood(Integer meta, int count) {
        super(ItemID.MANGROVE_WOOD, meta, count, "Mangrove Wood");
        this.block = Block.get(BlockID.MANGROVE_WOOD, meta);
    }
}