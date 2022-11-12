package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityZombieVillager;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZombieVillagerSpawnEgg extends ItemSpawnEgg {

    public ItemZombieVillagerSpawnEgg() {
        this(0, 1);
    }

    public ItemZombieVillagerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZombieVillagerSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOMBIE_VILLAGER_SPAWN_EGG, meta, count, "Zombie Villager Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityZombieVillager.NETWORK_ID;
    }
}