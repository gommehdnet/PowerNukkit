package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMagentaCandleCake extends Block {

    @Override
    public BlockID getId() {
        return BlockID.MAGENTA_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Magenta Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MAGENTA_CANDLE_CAKE);
    }
}