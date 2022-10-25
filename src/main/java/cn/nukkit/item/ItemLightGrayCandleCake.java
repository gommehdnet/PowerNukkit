package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightGrayCandleCake extends Item {

    public ItemLightGrayCandleCake() {
        this(0, 1);
    }

    public ItemLightGrayCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemLightGrayCandleCake(Integer meta, int count) {
        super(ItemID.LIGHT_GRAY_CANDLE_CAKE, meta, count, "Light Gray Candle Cake");
        this.block = Block.get(BlockID.LIGHT_GRAY_CANDLE_CAKE, meta);
    }
}