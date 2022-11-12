package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityVindicator;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemVindicatorSpawnEgg extends ItemSpawnEgg {

    public ItemVindicatorSpawnEgg() {
        this(0, 1);
    }

    public ItemVindicatorSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemVindicatorSpawnEgg(Integer meta, int count) {
        super(ItemID.VINDICATOR_SPAWN_EGG, meta, count, "Vindicator Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityVindicator.NETWORK_ID;
    }
}