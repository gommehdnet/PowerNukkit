package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCandle extends Item {

    public ItemCandle() {
        this(0, 1);
    }

    public ItemCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemCandle(Integer meta, int count) {
        super(ItemID.CANDLE, meta, count, "Candle");
        this.block = Block.get(BlockID.CANDLE, meta);
    }
}