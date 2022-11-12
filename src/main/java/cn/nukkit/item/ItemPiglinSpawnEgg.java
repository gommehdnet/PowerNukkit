package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityPiglin;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPiglinSpawnEgg extends ItemSpawnEgg {

    public ItemPiglinSpawnEgg() {
        this(0, 1);
    }

    public ItemPiglinSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPiglinSpawnEgg(Integer meta, int count) {
        super(ItemID.PIGLIN_SPAWN_EGG, meta, count, "Piglin Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityPiglin.NETWORK_ID;
    }
}