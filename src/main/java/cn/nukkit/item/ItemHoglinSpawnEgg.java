package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityHoglin;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHoglinSpawnEgg extends ItemSpawnEgg {

    public ItemHoglinSpawnEgg() {
        this(0, 1);
    }

    public ItemHoglinSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemHoglinSpawnEgg(Integer meta, int count) {
        super(ItemID.HOGLIN_SPAWN_EGG, meta, count, "Hoglin Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityHoglin.NETWORK_ID;
    }
}