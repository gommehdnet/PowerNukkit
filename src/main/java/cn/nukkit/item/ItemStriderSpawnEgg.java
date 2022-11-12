package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityStrider;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStriderSpawnEgg extends ItemSpawnEgg {

    public ItemStriderSpawnEgg() {
        this(0, 1);
    }

    public ItemStriderSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemStriderSpawnEgg(Integer meta, int count) {
        super(ItemID.STRIDER_SPAWN_EGG, meta, count, "Strider Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityStrider.NETWORK_ID;
    }
}