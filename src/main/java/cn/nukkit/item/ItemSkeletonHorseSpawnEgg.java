package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSkeletonHorseSpawnEgg extends Item {

    public ItemSkeletonHorseSpawnEgg() {
        this(0, 1);
    }

    public ItemSkeletonHorseSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSkeletonHorseSpawnEgg(Integer meta, int count) {
        super(ItemID.SKELETON_HORSE_SPAWN_EGG, meta, count, "Skeleton Horse Spawn Egg");
    }
}