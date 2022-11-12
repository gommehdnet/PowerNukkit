package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityFrog;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFrogSpawnEgg extends ItemSpawnEgg {

    public ItemFrogSpawnEgg() {
        this(0, 1);
    }

    public ItemFrogSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemFrogSpawnEgg(Integer meta, int count) {
        super(ItemID.FROG_SPAWN_EGG, meta, count, "Frog Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityFrog.NETWORK_ID;
    }
}