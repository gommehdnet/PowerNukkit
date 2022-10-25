package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockLimeCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.LIME_CANDLE;
    }

    @Override
    public String getName() {
        return "Lime Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LIME_CANDLE);
    }
}