package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityGhast;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGhastSpawnEgg extends ItemSpawnEgg {

    public ItemGhastSpawnEgg() {
        this(0, 1);
    }

    public ItemGhastSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemGhastSpawnEgg(Integer meta, int count) {
        super(ItemID.GHAST_SPAWN_EGG, meta, count, "Ghast Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityGhast.NETWORK_ID;
    }
}