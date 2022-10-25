package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStriderSpawnEgg extends Item {

    public ItemStriderSpawnEgg() {
        this(0, 1);
    }

    public ItemStriderSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemStriderSpawnEgg(Integer meta, int count) {
        super(ItemID.STRIDER_SPAWN_EGG, meta, count, "Strider Spawn Egg");
    }
}