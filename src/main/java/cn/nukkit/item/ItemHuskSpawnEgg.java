package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHuskSpawnEgg extends Item {

    public ItemHuskSpawnEgg() {
        this(0, 1);
    }

    public ItemHuskSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemHuskSpawnEgg(Integer meta, int count) {
        super(ItemID.HUSK_SPAWN_EGG, meta, count, "Husk Spawn Egg");
    }
}