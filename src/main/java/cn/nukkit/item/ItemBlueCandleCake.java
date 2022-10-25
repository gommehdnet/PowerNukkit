package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlueCandleCake extends Item {

    public ItemBlueCandleCake() {
        this(0, 1);
    }

    public ItemBlueCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemBlueCandleCake(Integer meta, int count) {
        super(ItemID.BLUE_CANDLE_CAKE, meta, count, "Blue Candle Cake");
        this.block = Block.get(BlockID.BLUE_CANDLE_CAKE, meta);
    }
}