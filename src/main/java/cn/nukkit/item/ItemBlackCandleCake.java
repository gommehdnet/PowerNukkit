package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlackCandleCake extends Item {

    public ItemBlackCandleCake() {
        this(0, 1);
    }

    public ItemBlackCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemBlackCandleCake(Integer meta, int count) {
        super(ItemID.BLACK_CANDLE_CAKE, meta, count, "Black Candle Cake");
        this.block = Block.get(BlockID.BLACK_CANDLE_CAKE, meta);
    }
}