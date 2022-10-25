package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAncientDebris extends Item {

    public ItemAncientDebris() {
        this(0, 1);
    }

    public ItemAncientDebris(Integer meta) {
        this(meta, 1);
    }

    public ItemAncientDebris(Integer meta, int count) {
        super(ItemID.ANCIENT_DEBRIS, meta, count, "Ancient Debris");
        this.block = Block.get(BlockID.ANCIENT_DEBRIS, meta);
    }
}