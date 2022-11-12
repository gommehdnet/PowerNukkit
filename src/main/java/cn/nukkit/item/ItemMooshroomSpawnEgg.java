package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityMooshroom;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMooshroomSpawnEgg extends ItemSpawnEgg {

    public ItemMooshroomSpawnEgg() {
        this(0, 1);
    }

    public ItemMooshroomSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemMooshroomSpawnEgg(Integer meta, int count) {
        super(ItemID.MOOSHROOM_SPAWN_EGG, meta, count, "Mooshroom Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityMooshroom.NETWORK_ID;
    }
}