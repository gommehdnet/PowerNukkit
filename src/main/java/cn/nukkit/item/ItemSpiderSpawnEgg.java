package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntitySpider;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpiderSpawnEgg extends ItemSpawnEgg {

    public ItemSpiderSpawnEgg() {
        this(0, 1);
    }

    public ItemSpiderSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSpiderSpawnEgg(Integer meta, int count) {
        super(ItemID.SPIDER_SPAWN_EGG, meta, count, "Spider Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntitySpider.NETWORK_ID;
    }
}