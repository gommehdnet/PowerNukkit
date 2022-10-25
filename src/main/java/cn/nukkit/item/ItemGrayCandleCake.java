package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGrayCandleCake extends Item {

    public ItemGrayCandleCake() {
        this(0, 1);
    }

    public ItemGrayCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemGrayCandleCake(Integer meta, int count) {
        super(ItemID.GRAY_CANDLE_CAKE, meta, count, "Gray Candle Cake");
        this.block = Block.get(BlockID.GRAY_CANDLE_CAKE, meta);
    }
}