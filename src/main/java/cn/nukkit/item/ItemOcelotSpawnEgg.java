package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityOcelot;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOcelotSpawnEgg extends ItemSpawnEgg {

    public ItemOcelotSpawnEgg() {
        this(0, 1);
    }

    public ItemOcelotSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemOcelotSpawnEgg(Integer meta, int count) {
        super(ItemID.OCELOT_SPAWN_EGG, meta, count, "Ocelot Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityOcelot.NETWORK_ID;
    }
}