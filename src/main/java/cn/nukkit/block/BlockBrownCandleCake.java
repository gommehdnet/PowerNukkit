package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockBrownCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.BROWN_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Brown Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BROWN_CANDLE_CAKE);
    }
}