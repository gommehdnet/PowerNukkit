package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPinkCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.PINK_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Pink Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.PINK_CANDLE_CAKE);
    }
}