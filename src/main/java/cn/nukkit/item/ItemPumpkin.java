package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPumpkin extends Item {

    public ItemPumpkin() {
        this(0, 1);
    }

    public ItemPumpkin(Integer meta) {
        this(meta, 1);
    }

    public ItemPumpkin(Integer meta, int count) {
        super(ItemID.PUMPKIN, meta, count, "Pumpkin");
        this.block = Block.get(BlockID.PUMPKIN, meta);
    }
}