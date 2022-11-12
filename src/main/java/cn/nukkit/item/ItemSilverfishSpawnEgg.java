package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntitySilverfish;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSilverfishSpawnEgg extends ItemSpawnEgg {

    public ItemSilverfishSpawnEgg() {
        this(0, 1);
    }

    public ItemSilverfishSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSilverfishSpawnEgg(Integer meta, int count) {
        super(ItemID.SILVERFISH_SPAWN_EGG, meta, count, "Silverfish Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntitySilverfish.NETWORK_ID;
    }
}