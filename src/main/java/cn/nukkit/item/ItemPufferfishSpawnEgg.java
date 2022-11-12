package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityPufferfish;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPufferfishSpawnEgg extends ItemSpawnEgg {

    public ItemPufferfishSpawnEgg() {
        this(0, 1);
    }

    public ItemPufferfishSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPufferfishSpawnEgg(Integer meta, int count) {
        super(ItemID.PUFFERFISH_SPAWN_EGG, meta, count, "Pufferfish Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityPufferfish.NETWORK_ID;
    }
}