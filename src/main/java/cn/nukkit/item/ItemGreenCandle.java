package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGreenCandle extends Item {

    public ItemGreenCandle() {
        this(0, 1);
    }

    public ItemGreenCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemGreenCandle(Integer meta, int count) {
        super(ItemID.GREEN_CANDLE, meta, count, "Green Candle");
        this.block = Block.get(BlockID.GREEN_CANDLE, meta);
    }
}