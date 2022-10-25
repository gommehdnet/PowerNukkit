package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemShulkerSpawnEgg extends Item {

    public ItemShulkerSpawnEgg() {
        this(0, 1);
    }

    public ItemShulkerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemShulkerSpawnEgg(Integer meta, int count) {
        super(ItemID.SHULKER_SPAWN_EGG, meta, count, "Shulker Spawn Egg");
    }
}