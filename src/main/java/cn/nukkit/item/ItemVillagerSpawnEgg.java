package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemVillagerSpawnEgg extends Item {

    public ItemVillagerSpawnEgg() {
        this(0, 1);
    }

    public ItemVillagerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemVillagerSpawnEgg(Integer meta, int count) {
        super(ItemID.VILLAGER_SPAWN_EGG, meta, count, "Villager Spawn Egg");
    }
}