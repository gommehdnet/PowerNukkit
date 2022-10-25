package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockRedCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.RED_CANDLE;
    }

    @Override
    public String getName() {
        return "Red Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RED_CANDLE);
    }
}