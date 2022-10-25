package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndermiteSpawnEgg extends Item {

    public ItemEndermiteSpawnEgg() {
        this(0, 1);
    }

    public ItemEndermiteSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemEndermiteSpawnEgg(Integer meta, int count) {
        super(ItemID.ENDERMITE_SPAWN_EGG, meta, count, "Endermite Spawn Egg");
    }
}