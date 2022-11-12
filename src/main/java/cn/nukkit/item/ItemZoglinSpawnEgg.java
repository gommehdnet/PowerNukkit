package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityZoglin;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZoglinSpawnEgg extends ItemSpawnEgg {

    public ItemZoglinSpawnEgg() {
        this(0, 1);
    }

    public ItemZoglinSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZoglinSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOGLIN_SPAWN_EGG, meta, count, "Zoglin Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityZoglin.NETWORK_ID;
    }
}