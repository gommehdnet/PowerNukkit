package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCyanCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CYAN_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Cyan Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CYAN_CANDLE_CAKE);
    }
}