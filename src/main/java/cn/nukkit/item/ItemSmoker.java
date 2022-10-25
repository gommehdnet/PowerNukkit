package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSmoker extends Item {

    public ItemSmoker() {
        this(0, 1);
    }

    public ItemSmoker(Integer meta) {
        this(meta, 1);
    }

    public ItemSmoker(Integer meta, int count) {
        super(ItemID.SMOKER, meta, count, "Smoker");
        this.block = Block.get(BlockID.SMOKER, meta);
    }
}