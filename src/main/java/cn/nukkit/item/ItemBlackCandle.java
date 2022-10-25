package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlackCandle extends Item {

    public ItemBlackCandle() {
        this(0, 1);
    }

    public ItemBlackCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemBlackCandle(Integer meta, int count) {
        super(ItemID.BLACK_CANDLE, meta, count, "Black Candle");
        this.block = Block.get(BlockID.BLACK_CANDLE, meta);
    }
}