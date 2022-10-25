package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCoralFanDead extends Item {

    public ItemCoralFanDead() {
        this(0, 1);
    }

    public ItemCoralFanDead(Integer meta) {
        this(meta, 1);
    }

    public ItemCoralFanDead(Integer meta, int count) {
        super(ItemID.CORAL_FAN_DEAD, meta, count, "Coral Fan Dead");
        this.block = Block.get(BlockID.CORAL_FAN_DEAD, meta);
    }
}