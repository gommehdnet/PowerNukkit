package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSalmonSpawnEgg extends Item {

    public ItemSalmonSpawnEgg() {
        this(0, 1);
    }

    public ItemSalmonSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSalmonSpawnEgg(Integer meta, int count) {
        super(ItemID.SALMON_SPAWN_EGG, meta, count, "Salmon Spawn Egg");
    }
}