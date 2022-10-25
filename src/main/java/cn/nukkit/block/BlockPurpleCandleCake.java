package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPurpleCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.PURPLE_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Purple Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.PURPLE_CANDLE_CAKE);
    }
}