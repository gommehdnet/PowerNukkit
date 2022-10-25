package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemParrotSpawnEgg extends Item {

    public ItemParrotSpawnEgg() {
        this(0, 1);
    }

    public ItemParrotSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemParrotSpawnEgg(Integer meta, int count) {
        super(ItemID.PARROT_SPAWN_EGG, meta, count, "Parrot Spawn Egg");
    }
}