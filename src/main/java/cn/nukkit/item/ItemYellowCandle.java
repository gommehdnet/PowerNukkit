package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemYellowCandle extends Item {

    public ItemYellowCandle() {
        this(0, 1);
    }

    public ItemYellowCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemYellowCandle(Integer meta, int count) {
        super(ItemID.YELLOW_CANDLE, meta, count, "Yellow Candle");
        this.block = Block.get(BlockID.YELLOW_CANDLE, meta);
    }
}