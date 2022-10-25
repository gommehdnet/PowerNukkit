package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPigSpawnEgg extends Item {

    public ItemPigSpawnEgg() {
        this(0, 1);
    }

    public ItemPigSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPigSpawnEgg(Integer meta, int count) {
        super(ItemID.PIG_SPAWN_EGG, meta, count, "Pig Spawn Egg");
    }
}