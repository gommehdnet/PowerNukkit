package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChickenSpawnEgg extends Item {

    public ItemChickenSpawnEgg() {
        this(0, 1);
    }

    public ItemChickenSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemChickenSpawnEgg(Integer meta, int count) {
        super(ItemID.CHICKEN_SPAWN_EGG, meta, count, "Chicken Spawn Egg");
    }
}