package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityCaveSpider;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCaveSpiderSpawnEgg extends ItemSpawnEgg {

    public ItemCaveSpiderSpawnEgg() {
        this(0, 1);
    }

    public ItemCaveSpiderSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCaveSpiderSpawnEgg(Integer meta, int count) {
        super(ItemID.CAVE_SPIDER_SPAWN_EGG, meta, count, "Cave Spider Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityCaveSpider.NETWORK_ID;
    }
}