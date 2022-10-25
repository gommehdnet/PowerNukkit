package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAllaySpawnEgg extends Item {

    public ItemAllaySpawnEgg() {
        this(0, 1);
    }

    public ItemAllaySpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemAllaySpawnEgg(Integer meta, int count) {
        super(ItemID.ALLAY_SPAWN_EGG, meta, count, "Allay Spawn Egg");
    }
}