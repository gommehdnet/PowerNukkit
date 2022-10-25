package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDonkeySpawnEgg extends Item {

    public ItemDonkeySpawnEgg() {
        this(0, 1);
    }

    public ItemDonkeySpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemDonkeySpawnEgg(Integer meta, int count) {
        super(ItemID.DONKEY_SPAWN_EGG, meta, count, "Donkey Spawn Egg");
    }
}