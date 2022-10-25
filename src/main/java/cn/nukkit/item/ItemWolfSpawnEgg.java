package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWolfSpawnEgg extends Item {

    public ItemWolfSpawnEgg() {
        this(0, 1);
    }

    public ItemWolfSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWolfSpawnEgg(Integer meta, int count) {
        super(ItemID.WOLF_SPAWN_EGG, meta, count, "Wolf Spawn Egg");
    }
}