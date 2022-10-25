package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBeeNest extends Item {

    public ItemBeeNest() {
        this(0, 1);
    }

    public ItemBeeNest(Integer meta) {
        this(meta, 1);
    }

    public ItemBeeNest(Integer meta, int count) {
        super(ItemID.BEE_NEST, meta, count, "Bee Nest");
        this.block = Block.get(BlockID.BEE_NEST, meta);
    }
}