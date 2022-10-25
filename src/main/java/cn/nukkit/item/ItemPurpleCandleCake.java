package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPurpleCandleCake extends Item {

    public ItemPurpleCandleCake() {
        this(0, 1);
    }

    public ItemPurpleCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemPurpleCandleCake(Integer meta, int count) {
        super(ItemID.PURPLE_CANDLE_CAKE, meta, count, "Purple Candle Cake");
        this.block = Block.get(BlockID.PURPLE_CANDLE_CAKE, meta);
    }
}