package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPandaSpawnEgg extends Item {

    public ItemPandaSpawnEgg() {
        this(0, 1);
    }

    public ItemPandaSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPandaSpawnEgg(Integer meta, int count) {
        super(ItemID.PANDA_SPAWN_EGG, meta, count, "Panda Spawn Egg");
    }
}