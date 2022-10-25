package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPhantomSpawnEgg extends Item {

    public ItemPhantomSpawnEgg() {
        this(0, 1);
    }

    public ItemPhantomSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPhantomSpawnEgg(Integer meta, int count) {
        super(ItemID.PHANTOM_SPAWN_EGG, meta, count, "Phantom Spawn Egg");
    }
}