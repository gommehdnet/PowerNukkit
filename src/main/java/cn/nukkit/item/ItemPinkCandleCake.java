package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPinkCandleCake extends Item {

    public ItemPinkCandleCake() {
        this(0, 1);
    }

    public ItemPinkCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemPinkCandleCake(Integer meta, int count) {
        super(ItemID.PINK_CANDLE_CAKE, meta, count, "Pink Candle Cake");
        this.block = Block.get(BlockID.PINK_CANDLE_CAKE, meta);
    }
}