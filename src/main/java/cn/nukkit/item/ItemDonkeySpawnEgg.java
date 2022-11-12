package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityDonkey;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDonkeySpawnEgg extends ItemSpawnEgg {

    public ItemDonkeySpawnEgg() {
        this(0, 1);
    }

    public ItemDonkeySpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemDonkeySpawnEgg(Integer meta, int count) {
        super(ItemID.DONKEY_SPAWN_EGG, meta, count, "Donkey Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityDonkey.NETWORK_ID;
    }
}