package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityCat;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCatSpawnEgg extends ItemSpawnEgg {

    public ItemCatSpawnEgg() {
        this(0, 1);
    }

    public ItemCatSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCatSpawnEgg(Integer meta, int count) {
        super(ItemID.CAT_SPAWN_EGG, meta, count, "Cat Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityCat.NETWORK_ID;
    }
}