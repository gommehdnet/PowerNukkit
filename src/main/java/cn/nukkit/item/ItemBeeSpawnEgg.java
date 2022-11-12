package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityBee;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBeeSpawnEgg extends ItemSpawnEgg {

    public ItemBeeSpawnEgg() {
        this(0, 1);
    }

    public ItemBeeSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemBeeSpawnEgg(Integer meta, int count) {
        super(ItemID.BEE_SPAWN_EGG, meta, count, "Bee Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityBee.NETWORK_ID;
    }
}