package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFrogSpawn extends Item {

    public ItemFrogSpawn() {
        this(0, 1);
    }

    public ItemFrogSpawn(Integer meta) {
        this(meta, 1);
    }

    public ItemFrogSpawn(Integer meta, int count) {
        super(ItemID.FROG_SPAWN, meta, count, "Frog Spawn");
        this.block = Block.get(BlockID.FROG_SPAWN, meta);
    }
}