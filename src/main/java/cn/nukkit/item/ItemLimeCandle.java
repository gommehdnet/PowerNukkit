package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLimeCandle extends Item {

    public ItemLimeCandle() {
        this(0, 1);
    }

    public ItemLimeCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemLimeCandle(Integer meta, int count) {
        super(ItemID.LIME_CANDLE, meta, count, "Lime Candle");
        this.block = Block.get(BlockID.LIME_CANDLE, meta);
    }
}