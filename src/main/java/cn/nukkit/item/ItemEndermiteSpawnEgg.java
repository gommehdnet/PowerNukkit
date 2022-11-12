package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityEndermite;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndermiteSpawnEgg extends ItemSpawnEgg {

    public ItemEndermiteSpawnEgg() {
        this(0, 1);
    }

    public ItemEndermiteSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemEndermiteSpawnEgg(Integer meta, int count) {
        super(ItemID.ENDERMITE_SPAWN_EGG, meta, count, "Endermite Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityEndermite.NETWORK_ID;
    }
}