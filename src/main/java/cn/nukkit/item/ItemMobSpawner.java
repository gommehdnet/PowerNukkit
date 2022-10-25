package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMobSpawner extends Item {

    public ItemMobSpawner() {
        this(0, 1);
    }

    public ItemMobSpawner(Integer meta) {
        this(meta, 1);
    }

    public ItemMobSpawner(Integer meta, int count) {
        super(ItemID.MOB_SPAWNER, meta, count, "Mob Spawner");
        this.block = Block.get(BlockID.MOB_SPAWNER, meta);
    }
}