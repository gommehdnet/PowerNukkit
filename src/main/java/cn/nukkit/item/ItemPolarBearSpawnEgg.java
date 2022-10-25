package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolarBearSpawnEgg extends Item {

    public ItemPolarBearSpawnEgg() {
        this(0, 1);
    }

    public ItemPolarBearSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPolarBearSpawnEgg(Integer meta, int count) {
        super(ItemID.POLAR_BEAR_SPAWN_EGG, meta, count, "Polar Bear Spawn Egg");
    }
}