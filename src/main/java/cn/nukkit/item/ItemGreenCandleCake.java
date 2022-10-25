package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGreenCandleCake extends Item {

    public ItemGreenCandleCake() {
        this(0, 1);
    }

    public ItemGreenCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemGreenCandleCake(Integer meta, int count) {
        super(ItemID.GREEN_CANDLE_CAKE, meta, count, "Green Candle Cake");
        this.block = Block.get(BlockID.GREEN_CANDLE_CAKE, meta);
    }
}