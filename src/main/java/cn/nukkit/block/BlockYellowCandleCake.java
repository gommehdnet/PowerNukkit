package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockYellowCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.YELLOW_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Yellow Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.YELLOW_CANDLE_CAKE);
    }
}