package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockLightGrayCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.LIGHT_GRAY_CANDLE;
    }

    @Override
    public String getName() {
        return "Light Gray Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LIGHT_GRAY_CANDLE);
    }
}