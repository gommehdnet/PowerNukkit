package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityPillager;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPillagerSpawnEgg extends ItemSpawnEgg {

    public ItemPillagerSpawnEgg() {
        this(0, 1);
    }

    public ItemPillagerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPillagerSpawnEgg(Integer meta, int count) {
        super(ItemID.PILLAGER_SPAWN_EGG, meta, count, "Pillager Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityPillager.NETWORK_ID;
    }
}