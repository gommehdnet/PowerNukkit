package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityVillager;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemVillagerSpawnEgg extends ItemSpawnEgg {

    public ItemVillagerSpawnEgg() {
        this(0, 1);
    }

    public ItemVillagerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemVillagerSpawnEgg(Integer meta, int count) {
        super(ItemID.VILLAGER_SPAWN_EGG, meta, count, "Villager Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityVillager.NETWORK_ID;
    }
}