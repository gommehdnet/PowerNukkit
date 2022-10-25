package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLimeCandleCake extends Item {

    public ItemLimeCandleCake() {
        this(0, 1);
    }

    public ItemLimeCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemLimeCandleCake(Integer meta, int count) {
        super(ItemID.LIME_CANDLE_CAKE, meta, count, "Lime Candle Cake");
        this.block = Block.get(BlockID.LIME_CANDLE_CAKE, meta);
    }
}