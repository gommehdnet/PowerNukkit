package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityCow;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCowSpawnEgg extends ItemSpawnEgg {

    public ItemCowSpawnEgg() {
        this(0, 1);
    }

    public ItemCowSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCowSpawnEgg(Integer meta, int count) {
        super(ItemID.COW_SPAWN_EGG, meta, count, "Cow Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityCow.NETWORK_ID;
    }
}