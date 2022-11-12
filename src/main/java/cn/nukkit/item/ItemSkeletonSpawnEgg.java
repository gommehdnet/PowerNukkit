package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntitySkeleton;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSkeletonSpawnEgg extends ItemSpawnEgg {

    public ItemSkeletonSpawnEgg() {
        this(0, 1);
    }

    public ItemSkeletonSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSkeletonSpawnEgg(Integer meta, int count) {
        super(ItemID.SKELETON_SPAWN_EGG, meta, count, "Skeleton Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntitySkeleton.NETWORK_ID;
    }
}