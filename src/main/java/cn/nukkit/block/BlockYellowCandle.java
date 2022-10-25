package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockYellowCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.YELLOW_CANDLE;
    }

    @Override
    public String getName() {
        return "Yellow Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.YELLOW_CANDLE);
    }
}