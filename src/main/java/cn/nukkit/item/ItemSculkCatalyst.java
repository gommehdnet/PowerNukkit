package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSculkCatalyst extends Item {

    public ItemSculkCatalyst() {
        this(0, 1);
    }

    public ItemSculkCatalyst(Integer meta) {
        this(meta, 1);
    }

    public ItemSculkCatalyst(Integer meta, int count) {
        super(ItemID.SCULK_CATALYST, meta, count, "Sculk Catalyst");
        this.block = Block.get(BlockID.SCULK_CATALYST, meta);
    }
}