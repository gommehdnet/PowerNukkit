package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCyanCandleCake extends Item {

    public ItemCyanCandleCake() {
        this(0, 1);
    }

    public ItemCyanCandleCake(Integer meta) {
        this(meta, 1);
    }

    public ItemCyanCandleCake(Integer meta, int count) {
        super(ItemID.CYAN_CANDLE_CAKE, meta, count, "Cyan Candle Cake");
        this.block = Block.get(BlockID.CYAN_CANDLE_CAKE, meta);
    }
}