package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGrayCandle extends Item {

    public ItemGrayCandle() {
        this(0, 1);
    }

    public ItemGrayCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemGrayCandle(Integer meta, int count) {
        super(ItemID.GRAY_CANDLE, meta, count, "Gray Candle");
        this.block = Block.get(BlockID.GRAY_CANDLE, meta);
    }
}