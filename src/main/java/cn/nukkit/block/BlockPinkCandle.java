package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPinkCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.PINK_CANDLE;
    }

    @Override
    public String getName() {
        return "Pink Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.PINK_CANDLE);
    }
}