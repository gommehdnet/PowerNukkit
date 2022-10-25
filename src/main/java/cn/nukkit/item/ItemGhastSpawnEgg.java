package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGhastSpawnEgg extends Item {

    public ItemGhastSpawnEgg() {
        this(0, 1);
    }

    public ItemGhastSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemGhastSpawnEgg(Integer meta, int count) {
        super(ItemID.GHAST_SPAWN_EGG, meta, count, "Ghast Spawn Egg");
    }
}