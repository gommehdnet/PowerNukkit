package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityZombie;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZombieSpawnEgg extends ItemSpawnEgg {

    public ItemZombieSpawnEgg() {
        this(0, 1);
    }

    public ItemZombieSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZombieSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOMBIE_SPAWN_EGG, meta, count, "Zombie Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityZombie.NETWORK_ID;
    }
}