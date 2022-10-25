package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStraySpawnEgg extends Item {

    public ItemStraySpawnEgg() {
        this(0, 1);
    }

    public ItemStraySpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemStraySpawnEgg(Integer meta, int count) {
        super(ItemID.STRAY_SPAWN_EGG, meta, count, "Stray Spawn Egg");
    }
}