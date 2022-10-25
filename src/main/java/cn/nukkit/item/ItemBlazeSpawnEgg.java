package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlazeSpawnEgg extends Item {

    public ItemBlazeSpawnEgg() {
        this(0, 1);
    }

    public ItemBlazeSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemBlazeSpawnEgg(Integer meta, int count) {
        super(ItemID.BLAZE_SPAWN_EGG, meta, count, "Blaze Spawn Egg");
    }
}