package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityMule;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMuleSpawnEgg extends ItemSpawnEgg {

    public ItemMuleSpawnEgg() {
        this(0, 1);
    }

    public ItemMuleSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemMuleSpawnEgg(Integer meta, int count) {
        super(ItemID.MULE_SPAWN_EGG, meta, count, "Mule Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityMule.NETWORK_ID;
    }
}