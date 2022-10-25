package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCandleCake extends Item {

    public ItemCandleCake() {
        this(0, 1);
    }

    public ItemCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemCandleCake(Integer meta, int count) {
        super(ItemID.CANDLE_CAKE, meta, count, "Candle Cake");
        this.block = Block.get(BlockID.CANDLE_CAKE, meta);
    }
}