package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityFox;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFoxSpawnEgg extends ItemSpawnEgg {

    public ItemFoxSpawnEgg() {
        this(0, 1);
    }

    public ItemFoxSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemFoxSpawnEgg(Integer meta, int count) {
        super(ItemID.FOX_SPAWN_EGG, meta, count, "Fox Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityFox.NETWORK_ID;
    }
}