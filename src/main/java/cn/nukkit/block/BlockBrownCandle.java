package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockBrownCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.BROWN_CANDLE;
    }

    @Override
    public String getName() {
        return "Brown Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BROWN_CANDLE);
    }
}