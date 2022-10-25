package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CANDLE_CAKE);
    }
}