package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityGoat;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGoatSpawnEgg extends ItemSpawnEgg {

    public ItemGoatSpawnEgg() {
        this(0, 1);
    }

    public ItemGoatSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemGoatSpawnEgg(Integer meta, int count) {
        super(ItemID.GOAT_SPAWN_EGG, meta, count, "Goat Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityGoat.NETWORK_ID;
    }
}