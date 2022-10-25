package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemYellowCandleCake extends Item {

    public ItemYellowCandleCake() {
        this(0, 1);
    }

    public ItemYellowCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemYellowCandleCake(Integer meta, int count) {
        super(ItemID.YELLOW_CANDLE_CAKE, meta, count, "Yellow Candle Cake");
        this.block = Block.get(BlockID.YELLOW_CANDLE_CAKE, meta);
    }
}