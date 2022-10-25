package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockGreenCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.GREEN_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Green Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.GREEN_CANDLE_CAKE);
    }
}