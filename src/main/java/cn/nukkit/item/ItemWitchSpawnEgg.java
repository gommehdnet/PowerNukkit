package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityWitch;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWitchSpawnEgg extends ItemSpawnEgg {

    public ItemWitchSpawnEgg() {
        this(0, 1);
    }

    public ItemWitchSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWitchSpawnEgg(Integer meta, int count) {
        super(ItemID.WITCH_SPAWN_EGG, meta, count, "Witch Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityWitch.NETWORK_ID;
    }
}