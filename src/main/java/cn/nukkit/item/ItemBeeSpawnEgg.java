package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBeeSpawnEgg extends Item {

    public ItemBeeSpawnEgg() {
        this(0, 1);
    }

    public ItemBeeSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemBeeSpawnEgg(Integer meta, int count) {
        super(ItemID.BEE_SPAWN_EGG, meta, count, "Bee Spawn Egg");
    }
}