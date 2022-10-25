package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZombieHorseSpawnEgg extends Item {

    public ItemZombieHorseSpawnEgg() {
        this(0, 1);
    }

    public ItemZombieHorseSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZombieHorseSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOMBIE_HORSE_SPAWN_EGG, meta, count, "Zombie Horse Spawn Egg");
    }
}