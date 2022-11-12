package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityEvoker;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEvokerSpawnEgg extends ItemSpawnEgg {

    public ItemEvokerSpawnEgg() {
        this(0, 1);
    }

    public ItemEvokerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemEvokerSpawnEgg(Integer meta, int count) {
        super(ItemID.EVOKER_SPAWN_EGG, meta, count, "Evoker Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityEvoker.NETWORK_ID;
    }
}