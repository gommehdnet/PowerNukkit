package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSeaPickle extends Item {

    public ItemSeaPickle() {
        this(0, 1);
    }

    public ItemSeaPickle(Integer meta) {
        this(meta, 1);
    }

    public ItemSeaPickle(Integer meta, int count) {
        super(ItemID.SEA_PICKLE, meta, count, "Sea Pickle");
        this.block = Block.get(BlockID.SEA_PICKLE, meta);
    }
}