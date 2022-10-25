package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZombieVillagerSpawnEgg extends Item {

    public ItemZombieVillagerSpawnEgg() {
        this(0, 1);
    }

    public ItemZombieVillagerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZombieVillagerSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOMBIE_VILLAGER_SPAWN_EGG, meta, count, "Zombie Villager Spawn Egg");
    }
}