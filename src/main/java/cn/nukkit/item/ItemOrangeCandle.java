package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOrangeCandle extends Item {

    public ItemOrangeCandle() {
        this(0, 1);
    }

    public ItemOrangeCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemOrangeCandle(Integer meta, int count) {
        super(ItemID.ORANGE_CANDLE, meta, count, "Orange Candle");
        this.block = Block.get(BlockID.ORANGE_CANDLE, meta);
    }
}