package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZombieSpawnEgg extends Item {

    public ItemZombieSpawnEgg() {
        this(0, 1);
    }

    public ItemZombieSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZombieSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOMBIE_SPAWN_EGG, meta, count, "Zombie Spawn Egg");
    }
}