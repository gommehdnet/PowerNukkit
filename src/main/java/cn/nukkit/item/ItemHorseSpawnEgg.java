package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityHorse;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHorseSpawnEgg extends ItemSpawnEgg {

    public ItemHorseSpawnEgg() {
        this(0, 1);
    }

    public ItemHorseSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemHorseSpawnEgg(Integer meta, int count) {
        super(ItemID.HORSE_SPAWN_EGG, meta, count, "Horse Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityHorse.NETWORK_ID;
    }
}