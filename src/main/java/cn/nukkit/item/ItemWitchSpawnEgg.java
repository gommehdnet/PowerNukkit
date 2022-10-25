package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWitchSpawnEgg extends Item {

    public ItemWitchSpawnEgg() {
        this(0, 1);
    }

    public ItemWitchSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWitchSpawnEgg(Integer meta, int count) {
        super(ItemID.WITCH_SPAWN_EGG, meta, count, "Witch Spawn Egg");
    }
}