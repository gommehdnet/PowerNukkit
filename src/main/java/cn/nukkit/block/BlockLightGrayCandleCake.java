package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockLightGrayCandleCake extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.LIGHT_GRAY_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Light Gray Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LIGHT_GRAY_CANDLE_CAKE);
    }
}