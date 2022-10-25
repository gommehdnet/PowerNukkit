package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWardenSpawnEgg extends Item {

    public ItemWardenSpawnEgg() {
        this(0, 1);
    }

    public ItemWardenSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWardenSpawnEgg(Integer meta, int count) {
        super(ItemID.WARDEN_SPAWN_EGG, meta, count, "Warden Spawn Egg");
    }
}