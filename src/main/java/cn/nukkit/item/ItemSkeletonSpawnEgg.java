package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSkeletonSpawnEgg extends Item {

    public ItemSkeletonSpawnEgg() {
        this(0, 1);
    }

    public ItemSkeletonSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSkeletonSpawnEgg(Integer meta, int count) {
        super(ItemID.SKELETON_SPAWN_EGG, meta, count, "Skeleton Spawn Egg");
    }
}