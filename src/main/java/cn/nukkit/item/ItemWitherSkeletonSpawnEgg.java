package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityWitherSkeleton;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWitherSkeletonSpawnEgg extends ItemSpawnEgg {

    public ItemWitherSkeletonSpawnEgg() {
        this(0, 1);
    }

    public ItemWitherSkeletonSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWitherSkeletonSpawnEgg(Integer meta, int count) {
        super(ItemID.WITHER_SKELETON_SPAWN_EGG, meta, count, "Wither Skeleton Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityWitherSkeleton.NETWORK_ID;
    }
}