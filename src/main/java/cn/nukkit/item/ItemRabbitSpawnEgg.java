package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRabbitSpawnEgg extends Item {

    public ItemRabbitSpawnEgg() {
        this(0, 1);
    }

    public ItemRabbitSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemRabbitSpawnEgg(Integer meta, int count) {
        super(ItemID.RABBIT_SPAWN_EGG, meta, count, "Rabbit Spawn Egg");
    }
}