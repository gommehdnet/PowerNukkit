package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntitySalmon;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSalmonSpawnEgg extends ItemSpawnEgg {

    public ItemSalmonSpawnEgg() {
        this(0, 1);
    }

    public ItemSalmonSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSalmonSpawnEgg(Integer meta, int count) {
        super(ItemID.SALMON_SPAWN_EGG, meta, count, "Salmon Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntitySalmon.NETWORK_ID;
    }
}