package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPiglinSpawnEgg extends Item {

    public ItemPiglinSpawnEgg() {
        this(0, 1);
    }

    public ItemPiglinSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPiglinSpawnEgg(Integer meta, int count) {
        super(ItemID.PIGLIN_SPAWN_EGG, meta, count, "Piglin Spawn Egg");
    }
}