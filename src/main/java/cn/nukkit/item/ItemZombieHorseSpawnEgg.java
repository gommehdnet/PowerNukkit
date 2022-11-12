package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityZombieHorse;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZombieHorseSpawnEgg extends ItemSpawnEgg {

    public ItemZombieHorseSpawnEgg() {
        this(0, 1);
    }

    public ItemZombieHorseSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZombieHorseSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOMBIE_HORSE_SPAWN_EGG, meta, count, "Zombie Horse Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityZombieHorse.NETWORK_ID;
    }
}