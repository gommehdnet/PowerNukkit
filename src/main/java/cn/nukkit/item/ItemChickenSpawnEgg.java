package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityChicken;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChickenSpawnEgg extends ItemSpawnEgg {

    public ItemChickenSpawnEgg() {
        this(0, 1);
    }

    public ItemChickenSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemChickenSpawnEgg(Integer meta, int count) {
        super(ItemID.CHICKEN_SPAWN_EGG, meta, count, "Chicken Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityChicken.NETWORK_ID;
    }
}