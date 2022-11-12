package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityPhantom;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPhantomSpawnEgg extends ItemSpawnEgg {

    public ItemPhantomSpawnEgg() {
        this(0, 1);
    }

    public ItemPhantomSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPhantomSpawnEgg(Integer meta, int count) {
        super(ItemID.PHANTOM_SPAWN_EGG, meta, count, "Phantom Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityPhantom.NETWORK_ID;
    }
}