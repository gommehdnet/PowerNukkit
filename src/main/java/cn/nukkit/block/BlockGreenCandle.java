package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockGreenCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.GREEN_CANDLE;
    }

    @Override
    public String getName() {
        return "Green Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.GREEN_CANDLE);
    }
}