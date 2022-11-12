package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityPolarBear;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolarBearSpawnEgg extends ItemSpawnEgg {

    public ItemPolarBearSpawnEgg() {
        this(0, 1);
    }

    public ItemPolarBearSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPolarBearSpawnEgg(Integer meta, int count) {
        super(ItemID.POLAR_BEAR_SPAWN_EGG, meta, count, "Polar Bear Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityPolarBear.NETWORK_ID;
    }
}