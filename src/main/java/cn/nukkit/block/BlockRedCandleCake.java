package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockRedCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.RED_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Red Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RED_CANDLE_CAKE);
    }
}