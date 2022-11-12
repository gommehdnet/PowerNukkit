package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityHusk;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHuskSpawnEgg extends ItemSpawnEgg {

    public ItemHuskSpawnEgg() {
        this(0, 1);
    }

    public ItemHuskSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemHuskSpawnEgg(Integer meta, int count) {
        super(ItemID.HUSK_SPAWN_EGG, meta, count, "Husk Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityHusk.NETWORK_ID;
    }
}