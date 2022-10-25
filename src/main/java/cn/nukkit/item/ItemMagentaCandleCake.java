package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMagentaCandleCake extends Item {

    public ItemMagentaCandleCake() {
        this(0, 1);
    }

    public ItemMagentaCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemMagentaCandleCake(Integer meta, int count) {
        super(ItemID.MAGENTA_CANDLE_CAKE, meta, count, "Magenta Candle Cake");
        this.block = Block.get(BlockID.MAGENTA_CANDLE_CAKE, meta);
    }
}