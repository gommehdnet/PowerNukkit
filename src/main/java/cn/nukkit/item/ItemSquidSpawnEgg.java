package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntitySquid;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSquidSpawnEgg extends ItemSpawnEgg {

    public ItemSquidSpawnEgg() {
        this(0, 1);
    }

    public ItemSquidSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSquidSpawnEgg(Integer meta, int count) {
        super(ItemID.SQUID_SPAWN_EGG, meta, count, "Squid Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntitySquid.NETWORK_ID;
    }
}