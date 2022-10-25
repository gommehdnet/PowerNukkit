package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockLimeCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.LIME_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Lime Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LIME_CANDLE_CAKE);
    }
}