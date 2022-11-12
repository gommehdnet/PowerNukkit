package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityDrowned;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDrownedSpawnEgg extends ItemSpawnEgg {

    public ItemDrownedSpawnEgg() {
        this(0, 1);
    }

    public ItemDrownedSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemDrownedSpawnEgg(Integer meta, int count) {
        super(ItemID.DROWNED_SPAWN_EGG, meta, count, "Drowned Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityDrowned.NETWORK_ID;
    }
}