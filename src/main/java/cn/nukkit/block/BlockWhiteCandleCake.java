package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWhiteCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.WHITE_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "White Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WHITE_CANDLE_CAKE);
    }
}