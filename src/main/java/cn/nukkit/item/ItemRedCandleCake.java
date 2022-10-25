package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedCandleCake extends Item {

    public ItemRedCandleCake() {
        this(0, 1);
    }

    public ItemRedCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemRedCandleCake(Integer meta, int count) {
        super(ItemID.RED_CANDLE_CAKE, meta, count, "Red Candle Cake");
        this.block = Block.get(BlockID.RED_CANDLE_CAKE, meta);
    }
}