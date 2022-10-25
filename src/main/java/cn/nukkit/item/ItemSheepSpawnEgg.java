package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSheepSpawnEgg extends Item {

    public ItemSheepSpawnEgg() {
        this(0, 1);
    }

    public ItemSheepSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSheepSpawnEgg(Integer meta, int count) {
        super(ItemID.SHEEP_SPAWN_EGG, meta, count, "Sheep Spawn Egg");
    }
}