package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityAllay;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAllaySpawnEgg extends ItemSpawnEgg {

    public ItemAllaySpawnEgg() {
        this(0, 1);
    }

    public ItemAllaySpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemAllaySpawnEgg(Integer meta, int count) {
        super(ItemID.ALLAY_SPAWN_EGG, meta, count, "Allay Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityAllay.NETWORK_ID;
    }
}