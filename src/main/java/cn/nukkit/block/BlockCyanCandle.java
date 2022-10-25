package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCyanCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.CYAN_CANDLE;
    }

    @Override
    public String getName() {
        return "Cyan Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CYAN_CANDLE);
    }
}