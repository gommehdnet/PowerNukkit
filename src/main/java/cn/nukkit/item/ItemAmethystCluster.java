package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAmethystCluster extends Item {

    public ItemAmethystCluster() {
        this(0, 1);
    }

    public ItemAmethystCluster(Integer meta) {
        this(meta, 1);
    }

    public ItemAmethystCluster(Integer meta, int count) {
        super(ItemID.AMETHYST_CLUSTER, meta, count, "Amethyst Cluster");
        this.block = Block.get(BlockID.AMETHYST_CLUSTER, meta);
    }
}