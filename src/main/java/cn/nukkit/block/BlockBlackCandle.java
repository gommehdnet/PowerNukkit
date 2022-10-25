package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockBlackCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.BLACK_CANDLE;
    }

    @Override
    public String getName() {
        return "Black Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BLACK_CANDLE);
    }
}