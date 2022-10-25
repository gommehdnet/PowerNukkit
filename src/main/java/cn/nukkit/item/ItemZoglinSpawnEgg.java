package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemZoglinSpawnEgg extends Item {

    public ItemZoglinSpawnEgg() {
        this(0, 1);
    }

    public ItemZoglinSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemZoglinSpawnEgg(Integer meta, int count) {
        super(ItemID.ZOGLIN_SPAWN_EGG, meta, count, "Zoglin Spawn Egg");
    }
}