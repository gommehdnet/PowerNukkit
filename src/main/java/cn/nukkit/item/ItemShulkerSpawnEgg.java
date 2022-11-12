package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityShulker;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemShulkerSpawnEgg extends ItemSpawnEgg {

    public ItemShulkerSpawnEgg() {
        this(0, 1);
    }

    public ItemShulkerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemShulkerSpawnEgg(Integer meta, int count) {
        super(ItemID.SHULKER_SPAWN_EGG, meta, count, "Shulker Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityShulker.NETWORK_ID;
    }
}