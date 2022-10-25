package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpiderSpawnEgg extends Item {

    public ItemSpiderSpawnEgg() {
        this(0, 1);
    }

    public ItemSpiderSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSpiderSpawnEgg(Integer meta, int count) {
        super(ItemID.SPIDER_SPAWN_EGG, meta, count, "Spider Spawn Egg");
    }
}