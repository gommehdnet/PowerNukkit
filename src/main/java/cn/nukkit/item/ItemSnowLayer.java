package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSnowLayer extends Item {

    public ItemSnowLayer() {
        this(0, 1);
    }

    public ItemSnowLayer(Integer meta) {
        this(meta, 1);
    }

    public ItemSnowLayer(Integer meta, int count) {
        super(ItemID.SNOW_LAYER, meta, count, "Snow Layer");
        this.block = Block.get(BlockID.SNOW_LAYER, meta);
    }
}