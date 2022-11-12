package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityBlaze;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlazeSpawnEgg extends ItemSpawnEgg {

    public ItemBlazeSpawnEgg() {
        this(0, 1);
    }

    public ItemBlazeSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemBlazeSpawnEgg(Integer meta, int count) {
        super(ItemID.BLAZE_SPAWN_EGG, meta, count, "Blaze Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityBlaze.NETWORK_ID;
    }
}