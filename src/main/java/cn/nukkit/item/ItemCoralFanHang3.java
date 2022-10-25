package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCoralFanHang3 extends Item {

    public ItemCoralFanHang3() {
        this(0, 1);
    }

    public ItemCoralFanHang3(Integer meta) {
        this(meta, 1);
    }

    public ItemCoralFanHang3(Integer meta, int count) {
        super(ItemID.CORAL_FAN_HANG3, meta, count, "Coral Fan Hang3");
        this.block = Block.get(BlockID.CORAL_FAN_HANG3, meta);
    }
}