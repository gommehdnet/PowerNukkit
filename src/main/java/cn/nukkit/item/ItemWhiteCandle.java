package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWhiteCandle extends Item {

    public ItemWhiteCandle() {
        this(0, 1);
    }

    public ItemWhiteCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemWhiteCandle(Integer meta, int count) {
        super(ItemID.WHITE_CANDLE, meta, count, "White Candle");
        this.block = Block.get(BlockID.WHITE_CANDLE, meta);
    }
}