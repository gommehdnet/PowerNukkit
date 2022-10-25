package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCreeperSpawnEgg extends Item {

    public ItemCreeperSpawnEgg() {
        this(0, 1);
    }

    public ItemCreeperSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCreeperSpawnEgg(Integer meta, int count) {
        super(ItemID.CREEPER_SPAWN_EGG, meta, count, "Creeper Spawn Egg");
    }
}