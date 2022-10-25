package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCoralFan extends Item {

    public ItemCoralFan() {
        this(0, 1);
    }

    public ItemCoralFan(Integer meta) {
        this(meta, 1);
    }

    public ItemCoralFan(Integer meta, int count) {
        super(ItemID.CORAL_FAN, meta, count, "Coral Fan");
        this.block = Block.get(BlockID.CORAL_FAN, meta);
    }
}