package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockGrayCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.GRAY_CANDLE;
    }

    @Override
    public String getName() {
        return "Gray Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.GRAY_CANDLE);
    }
}