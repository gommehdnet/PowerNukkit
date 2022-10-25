package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMuleSpawnEgg extends Item {

    public ItemMuleSpawnEgg() {
        this(0, 1);
    }

    public ItemMuleSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemMuleSpawnEgg(Integer meta, int count) {
        super(ItemID.MULE_SPAWN_EGG, meta, count, "Mule Spawn Egg");
    }
}