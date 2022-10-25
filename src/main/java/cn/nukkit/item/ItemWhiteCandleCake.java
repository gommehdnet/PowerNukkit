package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWhiteCandleCake extends Item {

    public ItemWhiteCandleCake() {
        this(0, 1);
    }

    public ItemWhiteCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemWhiteCandleCake(Integer meta, int count) {
        super(ItemID.WHITE_CANDLE_CAKE, meta, count, "White Candle Cake");
        this.block = Block.get(BlockID.WHITE_CANDLE_CAKE, meta);
    }
}