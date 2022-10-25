package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCowSpawnEgg extends Item {

    public ItemCowSpawnEgg() {
        this(0, 1);
    }

    public ItemCowSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCowSpawnEgg(Integer meta, int count) {
        super(ItemID.COW_SPAWN_EGG, meta, count, "Cow Spawn Egg");
    }
}