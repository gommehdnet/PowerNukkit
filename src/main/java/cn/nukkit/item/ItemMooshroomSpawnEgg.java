package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMooshroomSpawnEgg extends Item {

    public ItemMooshroomSpawnEgg() {
        this(0, 1);
    }

    public ItemMooshroomSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemMooshroomSpawnEgg(Integer meta, int count) {
        super(ItemID.MOOSHROOM_SPAWN_EGG, meta, count, "Mooshroom Spawn Egg");
    }
}