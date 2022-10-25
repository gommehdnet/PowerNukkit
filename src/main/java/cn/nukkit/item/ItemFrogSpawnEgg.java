package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFrogSpawnEgg extends Item {

    public ItemFrogSpawnEgg() {
        this(0, 1);
    }

    public ItemFrogSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemFrogSpawnEgg(Integer meta, int count) {
        super(ItemID.FROG_SPAWN_EGG, meta, count, "Frog Spawn Egg");
    }
}