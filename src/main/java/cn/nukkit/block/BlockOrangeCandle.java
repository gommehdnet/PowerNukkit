package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockOrangeCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.ORANGE_CANDLE;
    }

    @Override
    public String getName() {
        return "Orange Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ORANGE_CANDLE);
    }
}