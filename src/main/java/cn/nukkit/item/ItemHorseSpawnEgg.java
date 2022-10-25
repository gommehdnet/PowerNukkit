package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHorseSpawnEgg extends Item {

    public ItemHorseSpawnEgg() {
        this(0, 1);
    }

    public ItemHorseSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemHorseSpawnEgg(Integer meta, int count) {
        super(ItemID.HORSE_SPAWN_EGG, meta, count, "Horse Spawn Egg");
    }
}