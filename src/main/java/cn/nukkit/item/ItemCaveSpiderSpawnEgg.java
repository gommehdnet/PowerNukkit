package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCaveSpiderSpawnEgg extends Item {

    public ItemCaveSpiderSpawnEgg() {
        this(0, 1);
    }

    public ItemCaveSpiderSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCaveSpiderSpawnEgg(Integer meta, int count) {
        super(ItemID.CAVE_SPIDER_SPAWN_EGG, meta, count, "Cave Spider Spawn Egg");
    }
}