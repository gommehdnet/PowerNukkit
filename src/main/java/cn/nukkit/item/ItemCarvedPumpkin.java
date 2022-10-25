package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCarvedPumpkin extends Item {

    public ItemCarvedPumpkin() {
        this(0, 1);
    }

    public ItemCarvedPumpkin(Integer meta) {
        this(meta, 1);
    }

    public ItemCarvedPumpkin(Integer meta, int count) {
        super(ItemID.CARVED_PUMPKIN, meta, count, "Carved Pumpkin");
        this.block = Block.get(BlockID.CARVED_PUMPKIN, meta);
    }
}