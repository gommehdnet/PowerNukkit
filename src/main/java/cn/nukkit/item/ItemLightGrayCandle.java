package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightGrayCandle extends Item {

    public ItemLightGrayCandle() {
        this(0, 1);
    }

    public ItemLightGrayCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemLightGrayCandle(Integer meta, int count) {
        super(ItemID.LIGHT_GRAY_CANDLE, meta, count, "Light Gray Candle");
        this.block = Block.get(BlockID.LIGHT_GRAY_CANDLE, meta);
    }
}