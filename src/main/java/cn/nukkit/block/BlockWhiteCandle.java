package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWhiteCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.WHITE_CANDLE;
    }

    @Override
    public String getName() {
        return "White Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WHITE_CANDLE);
    }
}