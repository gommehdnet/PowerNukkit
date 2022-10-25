package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemInfoUpdate extends Item {

    public ItemInfoUpdate() {
        this(0, 1);
    }

    public ItemInfoUpdate(Integer meta) {
        this(meta, 1);
    }

    public ItemInfoUpdate(Integer meta, int count) {
        super(ItemID.INFO_UPDATE, meta, count, "Info Update");
        this.block = Block.get(BlockID.INFO_UPDATE, meta);
    }
}