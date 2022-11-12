package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityZombiePigman;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZombiePigmanSpawnEgg extends ItemSpawnEgg {

    public ItemZombiePigmanSpawnEgg() {
        this(0, 1);
    }

    public ItemZombiePigmanSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZombiePigmanSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOMBIE_PIGMAN_SPAWN_EGG, meta, count, "Zombie Pigman Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityZombiePigman.NETWORK_ID;
    }
}