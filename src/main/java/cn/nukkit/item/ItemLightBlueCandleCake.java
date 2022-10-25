package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightBlueCandleCake extends Item {

    public ItemLightBlueCandleCake() {
        this(0, 1);
    }

    public ItemLightBlueCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemLightBlueCandleCake(Integer meta, int count) {
        super(ItemID.LIGHT_BLUE_CANDLE_CAKE, meta, count, "Light Blue Candle Cake");
        this.block = Block.get(BlockID.LIGHT_BLUE_CANDLE_CAKE, meta);
    }
}