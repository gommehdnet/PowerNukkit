package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBatSpawnEgg extends Item {

    public ItemBatSpawnEgg() {
        this(0, 1);
    }

    public ItemBatSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemBatSpawnEgg(Integer meta, int count) {
        super(ItemID.BAT_SPAWN_EGG, meta, count, "Bat Spawn Egg");
    }
}