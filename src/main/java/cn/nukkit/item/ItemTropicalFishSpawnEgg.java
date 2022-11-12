package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityTropicalFish;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTropicalFishSpawnEgg extends ItemSpawnEgg {

    public ItemTropicalFishSpawnEgg() {
        this(0, 1);
    }

    public ItemTropicalFishSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemTropicalFishSpawnEgg(Integer meta, int count) {
        super(ItemID.TROPICAL_FISH_SPAWN_EGG, meta, count, "Tropical Fish Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityTropicalFish.NETWORK_ID;
    }
}