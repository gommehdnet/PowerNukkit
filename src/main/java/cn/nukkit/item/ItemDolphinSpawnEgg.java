package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDolphinSpawnEgg extends Item {

    public ItemDolphinSpawnEgg() {
        this(0, 1);
    }

    public ItemDolphinSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemDolphinSpawnEgg(Integer meta, int count) {
        super(ItemID.DOLPHIN_SPAWN_EGG, meta, count, "Dolphin Spawn Egg");
    }
}