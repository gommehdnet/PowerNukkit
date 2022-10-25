package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCyanCandle extends Item {

    public ItemCyanCandle() {
        this(0, 1);
    }

    public ItemCyanCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemCyanCandle(Integer meta, int count) {
        super(ItemID.CYAN_CANDLE, meta, count, "Cyan Candle");
        this.block = Block.get(BlockID.CYAN_CANDLE, meta);
    }
}