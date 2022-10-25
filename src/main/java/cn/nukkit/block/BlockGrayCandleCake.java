package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockGrayCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.GRAY_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Gray Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.GRAY_CANDLE_CAKE);
    }
}