package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBrownCandle extends Item {

    public ItemBrownCandle() {
        this(0, 1);
    }

    public ItemBrownCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemBrownCandle(Integer meta, int count) {
        super(ItemID.BROWN_CANDLE, meta, count, "Brown Candle");
        this.block = Block.get(BlockID.BROWN_CANDLE, meta);
    }
}