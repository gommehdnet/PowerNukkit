package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGoatSpawnEgg extends Item {

    public ItemGoatSpawnEgg() {
        this(0, 1);
    }

    public ItemGoatSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemGoatSpawnEgg(Integer meta, int count) {
        super(ItemID.GOAT_SPAWN_EGG, meta, count, "Goat Spawn Egg");
    }
}