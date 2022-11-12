package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityCreeper;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCreeperSpawnEgg extends ItemSpawnEgg {

    public ItemCreeperSpawnEgg() {
        this(0, 1);
    }

    public ItemCreeperSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCreeperSpawnEgg(Integer meta, int count) {
        super(ItemID.CREEPER_SPAWN_EGG, meta, count, "Creeper Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityCreeper.NETWORK_ID;
    }
}