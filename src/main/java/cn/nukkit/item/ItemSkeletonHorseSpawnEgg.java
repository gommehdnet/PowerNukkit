package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntitySkeletonHorse;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSkeletonHorseSpawnEgg extends ItemSpawnEgg {

    public ItemSkeletonHorseSpawnEgg() {
        this(0, 1);
    }

    public ItemSkeletonHorseSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSkeletonHorseSpawnEgg(Integer meta, int count) {
        super(ItemID.SKELETON_HORSE_SPAWN_EGG, meta, count, "Skeleton Horse Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntitySkeletonHorse.NETWORK_ID;
    }
}