package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCatSpawnEgg extends Item {

    public ItemCatSpawnEgg() {
        this(0, 1);
    }

    public ItemCatSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCatSpawnEgg(Integer meta, int count) {
        super(ItemID.CAT_SPAWN_EGG, meta, count, "Cat Spawn Egg");
    }
}