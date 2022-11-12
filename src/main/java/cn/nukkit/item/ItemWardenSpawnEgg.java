package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityWarden;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWardenSpawnEgg extends ItemSpawnEgg {

    public ItemWardenSpawnEgg() {
        this(0, 1);
    }

    public ItemWardenSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWardenSpawnEgg(Integer meta, int count) {
        super(ItemID.WARDEN_SPAWN_EGG, meta, count, "Warden Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityWarden.NETWORK_ID;
    }
}