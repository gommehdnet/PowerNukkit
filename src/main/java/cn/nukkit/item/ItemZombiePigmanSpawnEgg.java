package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZombiePigmanSpawnEgg extends Item {

    public ItemZombiePigmanSpawnEgg() {
        this(0, 1);
    }

    public ItemZombiePigmanSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZombiePigmanSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOMBIE_PIGMAN_SPAWN_EGG, meta, count, "Zombie Pigman Spawn Egg");
    }
}