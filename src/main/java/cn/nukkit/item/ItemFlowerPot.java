package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Snake1999
 * @since 2016/2/4
 */
public class ItemFlowerPot extends Item {

    public ItemFlowerPot() {
        this(0, 1);
    }

    public ItemFlowerPot(Integer meta) {
        this(meta, 1);
    }

    public ItemFlowerPot(Integer meta, int count) {
        super(ItemID.FLOWER_POT, meta, count, "Flower Pot");
        this.block = Block.get(BlockID.FLOWER_POT);
    }

}
