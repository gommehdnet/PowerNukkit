package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSilverfishSpawnEgg extends Item {

    public ItemSilverfishSpawnEgg() {
        this(0, 1);
    }

    public ItemSilverfishSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSilverfishSpawnEgg(Integer meta, int count) {
        super(ItemID.SILVERFISH_SPAWN_EGG, meta, count, "Silverfish Spawn Egg");
    }
}