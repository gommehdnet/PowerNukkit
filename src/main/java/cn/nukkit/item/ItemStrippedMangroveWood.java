package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedMangroveWood extends Item {

    public ItemStrippedMangroveWood() {
        this(0, 1);
    }

    public ItemStrippedMangroveWood(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedMangroveWood(Integer meta, int count) {
        super(ItemID.STRIPPED_MANGROVE_WOOD, meta, count, "Stripped Mangrove Wood");
        this.block = Block.get(BlockID.STRIPPED_MANGROVE_WOOD, meta);
    }
}