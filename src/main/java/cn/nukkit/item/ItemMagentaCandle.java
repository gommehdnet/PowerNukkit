package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMagentaCandle extends Item {

    public ItemMagentaCandle() {
        this(0, 1);
    }

    public ItemMagentaCandle(Integer meta) {
        this(meta, 1);
    }

    public ItemMagentaCandle(Integer meta, int count) {
        super(ItemID.MAGENTA_CANDLE, meta, count, "Magenta Candle");
        this.block = Block.get(BlockID.MAGENTA_CANDLE, meta);
    }
}