package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAxolotlSpawnEgg extends Item {

    public ItemAxolotlSpawnEgg() {
        this(0, 1);
    }

    public ItemAxolotlSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemAxolotlSpawnEgg(Integer meta, int count) {
        super(ItemID.AXOLOTL_SPAWN_EGG, meta, count, "Axolotl Spawn Egg");
    }
}