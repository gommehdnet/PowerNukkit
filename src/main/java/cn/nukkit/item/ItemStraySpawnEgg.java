package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityStray;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStraySpawnEgg extends ItemSpawnEgg {

    public ItemStraySpawnEgg() {
        this(0, 1);
    }

    public ItemStraySpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemStraySpawnEgg(Integer meta, int count) {
        super(ItemID.STRAY_SPAWN_EGG, meta, count, "Stray Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityStray.NETWORK_ID;
    }
}