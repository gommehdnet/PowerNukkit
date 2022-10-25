package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedCandle extends Item {

    public ItemRedCandle() {
        this(0, 1);
    }

    public ItemRedCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemRedCandle(Integer meta, int count) {
        super(ItemID.RED_CANDLE, meta, count, "Red Candle");
        this.block = Block.get(BlockID.RED_CANDLE, meta);
    }
}