package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPinkCandle extends Item {

    public ItemPinkCandle() {
        this(0, 1);
    }

    public ItemPinkCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemPinkCandle(Integer meta, int count) {
        super(ItemID.PINK_CANDLE, meta, count, "Pink Candle");
        this.block = Block.get(BlockID.PINK_CANDLE, meta);
    }
}