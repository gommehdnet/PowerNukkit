package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityPanda;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPandaSpawnEgg extends ItemSpawnEgg {

    public ItemPandaSpawnEgg() {
        this(0, 1);
    }

    public ItemPandaSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPandaSpawnEgg(Integer meta, int count) {
        super(ItemID.PANDA_SPAWN_EGG, meta, count, "Panda Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityPanda.NETWORK_ID;
    }
}