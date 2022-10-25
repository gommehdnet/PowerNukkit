package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockBlackCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.BLACK_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Black Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BLACK_CANDLE_CAKE);
    }
}