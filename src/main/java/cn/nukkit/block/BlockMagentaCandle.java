package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMagentaCandle extends BlockCandle {

    @Override
    public BlockID getId() {
        return BlockID.MAGENTA_CANDLE;
    }

    @Override
    public String getName() {
        return "Magenta Candle";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MAGENTA_CANDLE);
    }
}