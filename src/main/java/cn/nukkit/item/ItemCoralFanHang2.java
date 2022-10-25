package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCoralFanHang2 extends Item {

    public ItemCoralFanHang2() {
        this(0, 1);
    }

    public ItemCoralFanHang2(Integer meta) {
        this(meta, 1);
    }

    public ItemCoralFanHang2(Integer meta, int count) {
        super(ItemID.CORAL_FAN_HANG2, meta, count, "Coral Fan Hang2");
        this.block = Block.get(BlockID.CORAL_FAN_HANG2, meta);
    }
}