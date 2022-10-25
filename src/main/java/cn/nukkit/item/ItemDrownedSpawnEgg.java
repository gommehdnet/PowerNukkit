package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDrownedSpawnEgg extends Item {

    public ItemDrownedSpawnEgg() {
        this(0, 1);
    }

    public ItemDrownedSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemDrownedSpawnEgg(Integer meta, int count) {
        super(ItemID.DROWNED_SPAWN_EGG, meta, count, "Drowned Spawn Egg");
    }
}