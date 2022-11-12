package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityRabbit;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRabbitSpawnEgg extends ItemSpawnEgg {

    public ItemRabbitSpawnEgg() {
        this(0, 1);
    }

    public ItemRabbitSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemRabbitSpawnEgg(Integer meta, int count) {
        super(ItemID.RABBIT_SPAWN_EGG, meta, count, "Rabbit Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityRabbit.NETWORK_ID;
    }
}