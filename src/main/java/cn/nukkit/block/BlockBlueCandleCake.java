package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockBlueCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.BLUE_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Blue Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BLUE_CANDLE_CAKE);
    }
}