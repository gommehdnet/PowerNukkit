package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTropicalFishSpawnEgg extends Item {

    public ItemTropicalFishSpawnEgg() {
        this(0, 1);
    }

    public ItemTropicalFishSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemTropicalFishSpawnEgg(Integer meta, int count) {
        super(ItemID.TROPICAL_FISH_SPAWN_EGG, meta, count, "Tropical Fish Spawn Egg");
    }
}