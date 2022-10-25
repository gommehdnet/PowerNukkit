package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPufferfishSpawnEgg extends Item {

    public ItemPufferfishSpawnEgg() {
        this(0, 1);
    }

    public ItemPufferfishSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPufferfishSpawnEgg(Integer meta, int count) {
        super(ItemID.PUFFERFISH_SPAWN_EGG, meta, count, "Pufferfish Spawn Egg");
    }
}