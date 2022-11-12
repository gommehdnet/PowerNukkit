package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityElderGuardian;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElderGuardianSpawnEgg extends ItemSpawnEgg {

    public ItemElderGuardianSpawnEgg() {
        this(0, 1);
    }

    public ItemElderGuardianSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemElderGuardianSpawnEgg(Integer meta, int count) {
        super(ItemID.ELDER_GUARDIAN_SPAWN_EGG, meta, count, "Elder Guardian Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityElderGuardian.NETWORK_ID;
    }
}