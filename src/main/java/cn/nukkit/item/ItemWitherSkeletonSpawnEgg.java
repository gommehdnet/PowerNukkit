package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWitherSkeletonSpawnEgg extends Item {

    public ItemWitherSkeletonSpawnEgg() {
        this(0, 1);
    }

    public ItemWitherSkeletonSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWitherSkeletonSpawnEgg(Integer meta, int count) {
        super(ItemID.WITHER_SKELETON_SPAWN_EGG, meta, count, "Wither Skeleton Spawn Egg");
    }
}