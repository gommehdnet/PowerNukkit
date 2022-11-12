package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityParrot;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemParrotSpawnEgg extends ItemSpawnEgg {

    public ItemParrotSpawnEgg() {
        this(0, 1);
    }

    public ItemParrotSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemParrotSpawnEgg(Integer meta, int count) {
        super(ItemID.PARROT_SPAWN_EGG, meta, count, "Parrot Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityParrot.NETWORK_ID;
    }
}