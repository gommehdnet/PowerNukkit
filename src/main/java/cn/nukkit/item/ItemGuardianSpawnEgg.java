package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityGuardian;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGuardianSpawnEgg extends ItemSpawnEgg {

    public ItemGuardianSpawnEgg() {
        this(0, 1);
    }

    public ItemGuardianSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemGuardianSpawnEgg(Integer meta, int count) {
        super(ItemID.GUARDIAN_SPAWN_EGG, meta, count, "Guardian Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityGuardian.NETWORK_ID;
    }
}