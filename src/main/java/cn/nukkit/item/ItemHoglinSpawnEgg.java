package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHoglinSpawnEgg extends Item {

    public ItemHoglinSpawnEgg() {
        this(0, 1);
    }

    public ItemHoglinSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemHoglinSpawnEgg(Integer meta, int count) {
        super(ItemID.HOGLIN_SPAWN_EGG, meta, count, "Hoglin Spawn Egg");
    }
}