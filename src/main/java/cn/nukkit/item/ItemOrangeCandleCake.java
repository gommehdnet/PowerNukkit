package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOrangeCandleCake extends Item {

    public ItemOrangeCandleCake() {
        this(0, 1);
    }

    public ItemOrangeCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemOrangeCandleCake(Integer meta, int count) {
        super(ItemID.ORANGE_CANDLE_CAKE, meta, count, "Orange Candle Cake");
        this.block = Block.get(BlockID.ORANGE_CANDLE_CAKE, meta);
    }
}