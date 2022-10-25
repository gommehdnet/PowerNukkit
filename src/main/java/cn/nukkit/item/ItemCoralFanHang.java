package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCoralFanHang extends Item {

    public ItemCoralFanHang() {
        this(0, 1);
    }

    public ItemCoralFanHang(Integer meta) {
        this(meta, 1);
    }

    public ItemCoralFanHang(Integer meta, int count) {
        super(ItemID.CORAL_FAN_HANG, meta, count, "Coral Fan Hang");
        this.block = Block.get(BlockID.CORAL_FAN_HANG, meta);
    }
}