package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlueCandle extends Item {

    public ItemBlueCandle() {
        this(0, 1);
    }

    public ItemBlueCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemBlueCandle(Integer meta, int count) {
        super(ItemID.BLUE_CANDLE, meta, count, "Blue Candle");
        this.block = Block.get(BlockID.BLUE_CANDLE, meta);
    }
}