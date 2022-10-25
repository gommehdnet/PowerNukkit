package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPiglinBruteSpawnEgg extends Item {

    public ItemPiglinBruteSpawnEgg() {
        this(0, 1);
    }

    public ItemPiglinBruteSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPiglinBruteSpawnEgg(Integer meta, int count) {
        super(ItemID.PIGLIN_BRUTE_SPAWN_EGG, meta, count, "Piglin Brute Spawn Egg");
    }
}