package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightBlueCandle extends Item {

    public ItemLightBlueCandle() {
        this(0, 1);
    }

    public ItemLightBlueCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemLightBlueCandle(Integer meta, int count) {
        super(ItemID.LIGHT_BLUE_CANDLE, meta, count, "Light Blue Candle");
        this.block = Block.get(BlockID.LIGHT_BLUE_CANDLE, meta);
    }
}