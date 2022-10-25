package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBrownCandleCake extends Item {

    public ItemBrownCandleCake() {
        this(0, 1);
    }

    public ItemBrownCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemBrownCandleCake(Integer meta, int count) {
        super(ItemID.BROWN_CANDLE_CAKE, meta, count, "Brown Candle Cake");
        this.block = Block.get(BlockID.BROWN_CANDLE_CAKE, meta);
    }
}