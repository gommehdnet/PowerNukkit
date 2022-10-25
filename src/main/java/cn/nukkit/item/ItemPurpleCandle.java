package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPurpleCandle extends Item {

    public ItemPurpleCandle() {
        this(0, 1);
    }

    public ItemPurpleCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemPurpleCandle(Integer meta, int count) {
        super(ItemID.PURPLE_CANDLE, meta, count, "Purple Candle");
        this.block = Block.get(BlockID.PURPLE_CANDLE, meta);
    }
}