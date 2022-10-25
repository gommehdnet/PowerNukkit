package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPillagerSpawnEgg extends Item {

    public ItemPillagerSpawnEgg() {
        this(0, 1);
    }

    public ItemPillagerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPillagerSpawnEgg(Integer meta, int count) {
        super(ItemID.PILLAGER_SPAWN_EGG, meta, count, "Pillager Spawn Egg");
    }
}