package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityTadpole;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTadpoleSpawnEgg extends ItemSpawnEgg {

    public ItemTadpoleSpawnEgg() {
        this(0, 1);
    }

    public ItemTadpoleSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemTadpoleSpawnEgg(Integer meta, int count) {
        super(ItemID.TADPOLE_SPAWN_EGG, meta, count, "Tadpole Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityTadpole.NETWORK_ID;
    }
}