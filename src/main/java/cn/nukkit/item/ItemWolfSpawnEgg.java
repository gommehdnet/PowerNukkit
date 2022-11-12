package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityWolf;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWolfSpawnEgg extends ItemSpawnEgg {

    public ItemWolfSpawnEgg() {
        this(0, 1);
    }

    public ItemWolfSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWolfSpawnEgg(Integer meta, int count) {
        super(ItemID.WOLF_SPAWN_EGG, meta, count, "Wolf Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityWolf.NETWORK_ID;
    }
}