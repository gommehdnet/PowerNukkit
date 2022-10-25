package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRavagerSpawnEgg extends Item {

    public ItemRavagerSpawnEgg() {
        this(0, 1);
    }

    public ItemRavagerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemRavagerSpawnEgg(Integer meta, int count) {
        super(ItemID.RAVAGER_SPAWN_EGG, meta, count, "Ravager Spawn Egg");
    }
}